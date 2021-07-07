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
import com.java.virtusVer010.model.ElementoComponente;
import com.java.virtusVer010.repository.ElementoComponenteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ElementoComponenteController {
	
    @Autowired
	private ElementoComponenteRepository elementoComponenteRepository;
    @RequestMapping(value = "/elemento-componente")
    //All users list
	@GetMapping("/elemento-componente")
	public List<ElementoComponente> getElementoComponentes(){
    	List<ElementoComponente> elementoComponentevar = elementoComponenteRepository.findAll();
    	return elementoComponentevar;
	  	
	}
	//create user
	@PostMapping("/elemento-componente") 
	public ElementoComponente createElementoComponente(@RequestBody ElementoComponente elementoComponente) {
		return elementoComponenteRepository.save(elementoComponente);
	}
	
	//get user by id
    @GetMapping(value = "/elemento-componente/{id}")
    public ResponseEntity <ElementoComponente> getElementoComponenteById(@PathVariable Long id) {		
    	ElementoComponente elementoComponente = elementoComponenteRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("ElementoComponente nao encontrado:" + id));
		return ResponseEntity.ok(elementoComponente);
	}
    //update user
    @PutMapping("/elemento-componente/{id}")
    public ResponseEntity<ElementoComponente> updateElementoComponente(@PathVariable Long id,@RequestBody ElementoComponente elementoComponenteMudar) {
    	ElementoComponente elementoComponente = elementoComponenteRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("ElementoComponente nao encontrado:" + id+ "nao foi possivel atualizar"));
    	elementoComponente.setNome(elementoComponenteMudar.getNome());
    	elementoComponente.setDescricao(elementoComponenteMudar.getDescricao());
    			
    	ElementoComponente updateElementoComponente = elementoComponenteRepository.save(elementoComponente);
		return ResponseEntity.ok(updateElementoComponente);
	}
    
    //delete method
    @DeleteMapping("/elemento-componente/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteElementoComponente(@PathVariable Long id) {
    	ElementoComponente elementoComponente = elementoComponenteRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("ElementoComponente nao encontrado:" + id));
     	
    	elementoComponenteRepository.delete(elementoComponente);
     	Map<String, Boolean> response = new HashMap<>();
     	response.put("deleted", Boolean.TRUE);
     	return  ResponseEntity.ok(response);
    
    }
}