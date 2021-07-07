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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.virtusVer010.exception.ResourceNotFoundException;
import com.java.virtusVer010.model.Componente;
import com.java.virtusVer010.repository.ComponenteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

//@ResponseBody
public class ComponenteController {
    
	@Autowired
	private ComponenteRepository componenteRepository;
    @RequestMapping(value = "/componente")    
    //All users list
	@GetMapping("/componente")
	public List<Componente> getComponentes(){
    	List<Componente> componentevar = componenteRepository.findAll();
    	return componentevar;
	  	
	}
	//create user
	@PostMapping("/componente") 
	public Componente createComponente(@RequestBody Componente componente) {
		return componenteRepository.save(componente);
	}
	
	//get user by id
    @GetMapping(value = "/componente/{id}")
    public ResponseEntity <Componente> getComponenteById(@PathVariable Long id) {		
    	Componente componente = componenteRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Componente nao encontrado:" + id));
		return ResponseEntity.ok(componente);
	}
    //update user
    @PutMapping("/componente/{id}")
    public ResponseEntity<Componente> updateComponente(@PathVariable Long id,@RequestBody Componente componenteMudar) {
    	Componente componente = componenteRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Componente nao encontrado:" + id+ "nao foi possivel atualizar"));
    	componente.setNome(componenteMudar.getNome());
    	componente.setDescricao(componenteMudar.getDescricao());
    			
    	Componente updateComponente = componenteRepository.save(componente);
		return ResponseEntity.ok(updateComponente);
	}
    
    //delete method
    @DeleteMapping("/componente/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteComponente(@PathVariable Long id) {
    	Componente componente = componenteRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Componente nao encontrado:" + id));
     	
    	componenteRepository.delete(componente);
     	Map<String, Boolean> response = new HashMap<>();
     	response.put("deleted", Boolean.TRUE);
     	return  ResponseEntity.ok(response);
    
    }
}
