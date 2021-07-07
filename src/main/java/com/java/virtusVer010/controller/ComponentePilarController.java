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
import com.java.virtusVer010.model.ComponentePilar;
import com.java.virtusVer010.repository.ComponentePilarRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class ComponentePilarController {
	
    @Autowired
	private ComponentePilarRepository ComponentePilarRepository;
    @RequestMapping(value = "/componente-pilar")
    //All users list
	@GetMapping("/componente-pilar")
	public List<ComponentePilar> getComponentePilars(){
    	List<ComponentePilar> ComponentePilarvar = ComponentePilarRepository.findAll();
    	return ComponentePilarvar;
	  	
	}
	//create user
	@PostMapping("/componente-pilar") 
	public ComponentePilar createComponentePilar(@RequestBody ComponentePilar ComponentePilar) {
		return ComponentePilarRepository.save(ComponentePilar);
	}
	
	//get user by id
    @GetMapping(value = "/componente-pilar/{id}")
    public ResponseEntity <ComponentePilar> getComponentePilarById(@PathVariable Long id) {		
    	ComponentePilar ComponentePilar = ComponentePilarRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("ComponentePilar nao encontrado:" + id));
		return ResponseEntity.ok(ComponentePilar);
    }
    //update user
    @PutMapping("/componente-pilar/{id}")
    public ResponseEntity<ComponentePilar> updateComponentePilar(@PathVariable Long id,@RequestBody ComponentePilar ComponentePilarMudar) {
    	ComponentePilar ComponentePilar = ComponentePilarRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("ComponentePilar nao encontrado:" + id+ "nao foi possivel atualizar"));
    	ComponentePilar.setNome(ComponentePilarMudar.getNome());
    	ComponentePilar.setSonda(ComponentePilarMudar.getSonda());
    	ComponentePilar.setIdAutor(ComponentePilarMudar.getIdAutor());
    	ComponentePilar.setCriadoEm(ComponentePilarMudar.getCriadoEm());
    	ComponentePilar.setIdVersaoOrigem(ComponentePilarMudar.getIdVersaoOrigem());
    	ComponentePilar.setIdStatus(ComponentePilarMudar.getIdStatus());
    	//ComponentePilar.setPilaresComponentePilar(ComponentePilarMudar.getPilaresComponentePilar());
    	
		
    	ComponentePilar updateComponentePilar = ComponentePilarRepository.save(ComponentePilar);
		return ResponseEntity.ok(updateComponentePilar);
	}
    
    //delete method
    @DeleteMapping("/componente-pilar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteComponentePilar(@PathVariable Long id) {
    	ComponentePilar ComponentePilar = ComponentePilarRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("ComponentePilar nao encontrado:" + id));
     	
     	ComponentePilarRepository.delete(ComponentePilar);
     	Map<String, Boolean> response = new HashMap<>();
     	response.put("deleted", Boolean.TRUE);
     	return  ResponseEntity.ok(response);
    
    }
}
