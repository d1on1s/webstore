package online.denseleznev.webstore.repository;

import online.denseleznev.webstore.domain.CartItem;
import online.denseleznev.webstore.domain.ItemToCartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ItemToCartItemRepository extends CrudRepository<ItemToCartItem, Long> {
	void deleteByCartItem(CartItem cartItem);
}
