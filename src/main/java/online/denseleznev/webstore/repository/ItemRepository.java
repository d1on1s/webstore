package online.denseleznev.webstore.repository;


import java.util.List;

import online.denseleznev.webstore.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{
	List<Item> findByCategory(String category);
	
	List<Item> findByNameContaining(String name);
}
