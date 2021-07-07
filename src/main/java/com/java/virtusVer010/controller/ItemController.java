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
import com.java.virtusVer010.model.Item;
import com.java.virtusVer010.repository.ItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ItemController {
    @Autowired
	private ItemRepository itemRepository;
    @RequestMapping(value = "/item")
    //All users list
	@GetMapping("/item")
	public List<Item> getItems(){
    	List<Item> itemvar = itemRepository.findAll();
    	return itemvar;
	  	
	}
	//create user
	@PostMapping("/item") 
	public Item createItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	//get user by id
    @GetMapping(value = "/item/{id}")
    public ResponseEntity <Item> getItemById(@PathVariable Long id) {		
    	Item item = itemRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Item nao encontrado:" + id));
		return ResponseEntity.ok(item);
	}
    //update user
    @PutMapping("/item/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,@RequestBody Item itemMudar) {
    	Item item = itemRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Item nao encontrado:" + id+ "nao foi possivel atualizar"));
    	item.setNome(itemMudar.getNome());
    	item.setDescricao(itemMudar.getDescricao());
    	item.setReferencia(itemMudar.getReferencia());
    	item.setIdAutor(itemMudar.getIdAutor());
    	item.setCriadoEm(itemMudar.getCriadoEm());
    	//id versao??
    	item.setIdStatus(itemMudar.getIdStatus());
    	//item.setPilaresitem(itemMudar.getPilaresitem());
    	
		
    	Item updateItem = itemRepository.save(item);
		return ResponseEntity.ok(updateItem);
	}
    
    //delete method
    @DeleteMapping("/item/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id) {
    	Item item = itemRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Item nao encontrado:" + id));
     	
     	itemRepository.delete(item);
     	Map<String, Boolean> response = new HashMap<>();
     	response.put("deleted", Boolean.TRUE);
     	return  ResponseEntity.ok(response);
    }
}