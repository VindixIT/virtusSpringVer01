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
import com.java.virtusVer010.model.Elemento;
import com.java.virtusVer010.repository.ElementoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class ElementoController {
    @Autowired
	private ElementoRepository elementoRepository;
    @RequestMapping(value = "/elemento")
    //All users list
	@GetMapping("/elemento")
	public List<Elemento> getElementos(){
    	List<Elemento> elementovar = elementoRepository.findAll();
    	return elementovar;
	  	
	}
	//create user
	@PostMapping("/elemento") 
	public Elemento createElemento(@RequestBody Elemento elemento) {
		return elementoRepository.save(elemento);
	}
	
	//get user by id
    @GetMapping(value = "/elemento/{id}")
    public ResponseEntity <Elemento> getElementoById(@PathVariable Long id) {		
    	Elemento elemento = elementoRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Elemento nao encontrado:" + id));
		return ResponseEntity.ok(elemento);
	}
    //update user
    @PutMapping("/elemento/{id}")
    public ResponseEntity<Elemento> updateElemento(@PathVariable Long id,@RequestBody Elemento elementoMudar) {
    	Elemento elemento = elementoRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Elemento nao encontrado:" + id+ "nao foi possivel atualizar"));
    	elemento.setNome(elementoMudar.getNome());
    	elemento.setDescricao(elementoMudar.getDescricao());
    	elemento.setReferencia(elementoMudar.getReferencia());
    	elemento.setPeso(elementoMudar.getPeso());
    	elemento.setIdAutor(elementoMudar.getIdAutor());
    	elemento.setCriadoEm(elementoMudar.getCriadoEm());
    	elemento.setIdStatus(elementoMudar.getIdStatus());
    			
    	Elemento updateElemento = elementoRepository.save(elemento);
		return ResponseEntity.ok(updateElemento);
	}
    
    //delete method
    @DeleteMapping("/elemento/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteElemento(@PathVariable Long id) {
    	Elemento elemento = elementoRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Elemento nao encontrado:" + id));
     	
    	elementoRepository.delete(elemento);
     	Map<String, Boolean> response = new HashMap<>();
     	response.put("deleted", Boolean.TRUE);
     	return  ResponseEntity.ok(response);
    
    }
}
