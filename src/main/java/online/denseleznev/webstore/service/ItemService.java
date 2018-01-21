package online.denseleznev.webstore.service;

import online.denseleznev.webstore.domain.Item;

import java.util.List;

public interface ItemService {
	List<Item> findAll ();
	
	Item findOne(Long id);
	
	List<Item> findByCategory(String category);
	
	List<Item> blurrySearch(String name);
}
