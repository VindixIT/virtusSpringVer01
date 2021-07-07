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
import com.java.virtusVer010.model.Ciclo;
import com.java.virtusVer010.repository.CicloRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class CicloController {
	
	@Autowired
	private CicloRepository cicloRepository;
    @RequestMapping(value = "/ciclo")
    //All users list
	@GetMapping("/ciclo")
	public List<Ciclo> getCiclos(){
    	List<Ciclo> ciclovar = cicloRepository.findAll();
    	return ciclovar;
	  	
	}
	//create user
	@PostMapping("/ciclo") 
	public Ciclo createCiclo(@RequestBody Ciclo ciclo) {
		return cicloRepository.save(ciclo);
	}
	
	//get user by id
    @GetMapping(value = "/ciclo/{id}")
    public ResponseEntity <Ciclo> getCicloById(@PathVariable Long id) {		
    	Ciclo ciclo = cicloRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Ciclo nao encontrado:" + id));
		return ResponseEntity.ok(ciclo);
	}
    //update user
    @PutMapping("/ciclo/{id}")
    public ResponseEntity<Ciclo> updateCiclo(@PathVariable Long id,@RequestBody Ciclo cicloMudar) {
    	Ciclo ciclo = cicloRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Ciclo nao encontrado:" + id+ "nao foi possivel atualizar"));
    	ciclo.setNome(cicloMudar.getNome());
    	ciclo.setDescricao(cicloMudar.getDescricao());
    	ciclo.setReferencia(cicloMudar.getReferencia());
    	ciclo.setIdAutor(cicloMudar.getIdAutor());
    	ciclo.setCriadoEm(cicloMudar.getCriadoEm());
    	ciclo.setIdVersaoOrigem(cicloMudar.getIdVersaoOrigem());
    	ciclo.setIdStatus(cicloMudar.getIdStatus());
    	//ciclo.setPilaresciclo(cicloMudar.getPilaresciclo());
    	
		
    	Ciclo updateCiclo = cicloRepository.save(ciclo);
		return ResponseEntity.ok(updateCiclo);
	}
    
    //delete method
    @DeleteMapping("/ciclo/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCiclo(@PathVariable Long id) {
    	Ciclo ciclo = cicloRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Ciclo nao encontrado:" + id));
     	
     	cicloRepository.delete(ciclo);
     	Map<String, Boolean> response = new HashMap<>();
     	response.put("deleted", Boolean.TRUE);
     	return  ResponseEntity.ok(response);
    
    }
}