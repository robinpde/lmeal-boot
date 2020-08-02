package com.hov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hov.model.Item;
import com.hov.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> saveItem(@RequestBody Item item){
		if(itemService.saveItem(item)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateItem(@RequestBody Item item){
		if(itemService.updateItem(item)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteItem(@RequestBody Item item){
		if(itemService.deleteItem(item)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@GetMapping("/getbyid/{itemid}")
	public ResponseEntity<Item> getItemById(@PathVariable("") String id){
		return new ResponseEntity<Item>(itemService.getItemById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getlist")
	@ResponseBody
	public List<Item> getAllItems(){
		return itemService.getAllItem();
	}
}
