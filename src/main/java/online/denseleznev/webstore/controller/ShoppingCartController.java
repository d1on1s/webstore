package online.denseleznev.webstore.controller;

import java.security.Principal;
import java.util.List;

import online.denseleznev.webstore.domain.CartItem;
import online.denseleznev.webstore.domain.Item;
import online.denseleznev.webstore.domain.ShoppingCart;
import online.denseleznev.webstore.domain.User;
import online.denseleznev.webstore.service.CartItemService;
import online.denseleznev.webstore.service.ItemService;
import online.denseleznev.webstore.service.ShoppingCartService;
import online.denseleznev.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}

	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("item") Item item,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		item = itemService.findOne(item.getId());
		
		if (Integer.parseInt(qty) > item.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/itemDetail?id="+item.getId();
		}
		
		CartItem cartItem = cartItemService.addItemToCartItem(item, user, Integer.parseInt(qty));
		model.addAttribute("addItemSuccess", true);
		
		return "forward:/itemDetail?id="+item.getId();
	}
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(
			@ModelAttribute("id") Long cartItemId,
			@ModelAttribute("qty") int qty
			) {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}
}
