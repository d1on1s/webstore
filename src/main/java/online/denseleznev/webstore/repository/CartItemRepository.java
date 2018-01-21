package online.denseleznev.webstore.repository;

import java.util.List;

import online.denseleznev.webstore.domain.CartItem;
import online.denseleznev.webstore.domain.Order;
import online.denseleznev.webstore.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long>{
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	List<CartItem> findByOrder(Order order);
}
