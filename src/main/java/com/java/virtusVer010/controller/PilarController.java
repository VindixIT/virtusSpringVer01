package com.java.virtusVer010.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.virtusVer010.exception.ResourceNotFoundException;
import com.java.virtusVer010.model.Pilar;
import com.java.virtusVer010.repository.PilarRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PilarController {
    @Autowired
	private PilarRepository pilarRepository;
    @RequestMapping(value = "/pilar")
    //All users list
	@GetMapping("/pilar")
	public List<Pilar> getPilars(){
    	List<Pilar> pilarvar = pilarRepository.findAll();
    	return pilarvar;
	  	
	}
	//create user
	@PostMapping("/pilar") 
	public Pilar createPilar(@RequestBody Pilar pilar) {
		return pilarRepository.save(pilar);
	}
	
	//get user by id
    @GetMapping(value = "/pilar/{id}")
    public ResponseEntity <Pilar> getPilarById(@PathVariable Long id) {		
    	Pilar pilar = pilarRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Pilar nao encontrado:" + id));
		return ResponseEntity.ok(pilar);
	}
    //update user
    @PutMapping("/pilar/{id}")
    public ResponseEntity<Pilar> updatePilar(@PathVariable Long id,@RequestBody Pilar pilarMudar) {
    	Pilar pilar = pilarRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Pilar nao encontrado:" + id+ "nao foi possivel atualizar"));
    	pilar.setNome(pilarMudar.getNome());
    	pilar.setDescricao(pilarMudar.getDescricao());
    	pilar.setReferencia(pilarMudar.getReferencia());
    	pilar.setIdAutor(pilarMudar.getIdAutor());
    	pilar.setCriadoEm(pilarMudar.getCriadoEm());
    	pilar.setIdVersaoOrigem(pilarMudar.getIdVersaoOrigem());
    	pilar.setIdStatus(pilarMudar.getIdStatus());
    	//pilar.setPilarespilar(pilarMudar.getPilarespilar());
    	
		
    	Pilar updatePilar = pilarRepository.save(pilar);
		return ResponseEntity.ok(updatePilar);
	}
    
    //delete method
    @DeleteMapping("/pilar/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePilar(@PathVariable Long id) {
    	Pilar pilar = pilarRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Pilar nao encontrado:" + id));
     	
     	pilarRepository.delete(pilar);
     	Map<String, Boolean> response = new HashMap<>();
     	response.put("deleted", Boolean.TRUE);
     	return  ResponseEntity.ok(response);
    }
}
