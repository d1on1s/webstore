package online.denseleznev.webstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import online.denseleznev.webstore.domain.Item;
import online.denseleznev.webstore.repository.ItemRepository;
import online.denseleznev.webstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findAll() {
		List<Item> itemList = (List<Item>) itemRepository.findAll();
		List<Item> activeItemList = new ArrayList<>();
		
		for (Item item : itemList) {
			if(item.isActive()) {
				activeItemList.add(item);
			}
		}
		
		return activeItemList;
	}
	
	public Item findOne(Long id) {
		return itemRepository.findOne(id);
	}

	public List<Item> findByCategory(String category){
		List<Item> itemList = itemRepository.findByCategory(category);
		
		List<Item> activeItemList = new ArrayList<>();
		
		for (Item item : itemList) {
			if(item.isActive()) {
				activeItemList.add(item);
			}
		}
		
		return activeItemList;
	}
	
	public List<Item> blurrySearch(String name) {
		List<Item> itemList = itemRepository.findByNameContaining(name);
		List<Item> activeItemList = new ArrayList<>();
		
		for (Item item : itemList) {
			if(item.isActive()) {
				activeItemList.add(item);
			}
		}
		
		return activeItemList;
	}
}
