package com.hov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hov.model.Item;
import com.hov.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	public boolean saveItem(Item item) {
		try{
			itemRepository.save(item);
			return true;
		}
		catch(Exception e){	
		}
		return false;
	}
	
	public boolean updateItem(Item item) {
		try{
			if(!"".equals(item.getItemId())) {
				itemRepository.save(item);
			}
			return true;
		}
		catch(Exception e){	
		}		
		return false;
	}
	
	public boolean deleteItem(Item item) {
		try{
			itemRepository.delete(item);
			return true;
		}
		catch(Exception e){	
		}
		return false;
	}
	
	public Item getItemById(String itemId) {
		return itemRepository.findById(itemId).get();
	}
	
	public List<Item> getAllItem(){
		return itemRepository.findAll();
	}
}
