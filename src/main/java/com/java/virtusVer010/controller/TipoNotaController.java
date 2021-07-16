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
import com.java.virtusVer010.model.TipoNota;
import com.java.virtusVer010.repository.TipoNotaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipoNotaController {
	   @Autowired
		private TipoNotaRepository tipoNotaRepository;
	    @RequestMapping(value = "/tipoNota")
	    //All users list
		@GetMapping("/tipoNota")
		public List<TipoNota> getTipoNotas(){
	    	List<TipoNota> tipoNotavar = tipoNotaRepository.findAll();
	    	return tipoNotavar;
		  	
		}
		//create user
		@PostMapping("/tipoNota") 
		public TipoNota createTipoNota(@RequestBody TipoNota tipoNota) {
			return tipoNotaRepository.save(tipoNota);
		}
		
		//get user by id
	    @GetMapping(value = "/tipoNota/{id}")
	    public ResponseEntity <TipoNota> getTipoNotaById(@PathVariable Long id) {		
	    	TipoNota tipoNota = tipoNotaRepository.findById(id)
	    			.orElseThrow(() -> new ResourceNotFoundException("TipoNota nao encontrado:" + id));
			return ResponseEntity.ok(tipoNota);
		}
	    //update user
	    @PutMapping("/tipoNota/{id}")
	    public ResponseEntity<TipoNota> updateTipoNota(@PathVariable Long id,@RequestBody TipoNota tipoNotaMudar) {
	    	TipoNota tipoNota = tipoNotaRepository.findById(id)
	    			.orElseThrow(() -> new ResourceNotFoundException("TipoNota nao encontrado:" + id+ "nao foi possivel atualizar"));
	    	tipoNota.setNome(tipoNotaMudar.getNome());
	    	tipoNota.setDescricao(tipoNotaMudar.getDescricao());
	    	tipoNota.setReferencia(tipoNotaMudar.getReferencia());
	    	tipoNota.setIdAutor(tipoNotaMudar.getIdAutor());
	    	tipoNota.setCriadoEm(tipoNotaMudar.getCriadoEm());
	    	tipoNota.setIdVersaoOrigem(tipoNotaMudar.getIdVersaoOrigem());
	    	tipoNota.setIdStatus(tipoNotaMudar.getIdStatus());
	    	//tipoNota.setTipoNotaestipoNota(tipoNotaMudar.getTipoNotaestipoNota());
	    	
			
	    	TipoNota updateTipoNota = tipoNotaRepository.save(tipoNota);
			return ResponseEntity.ok(updateTipoNota);
		}
	    
	    //delete method
	    @DeleteMapping("/tipoNota/{id}")
	    public ResponseEntity<Map<String, Boolean>> deleteTipoNota(@PathVariable Long id) {
	    	TipoNota tipoNota = tipoNotaRepository.findById(id)
	    			.orElseThrow(() -> new ResourceNotFoundException("TipoNota nao encontrado:" + id));
	     	
	     	tipoNotaRepository.delete(tipoNota);
	     	Map<String, Boolean> response = new HashMap<>();
	     	response.put("deleted", Boolean.TRUE);
	     	return  ResponseEntity.ok(response);
	    }
}