package online.denseleznev.webstore.controller;

import java.security.Principal;
import java.util.List;

import online.denseleznev.webstore.domain.Item;
import online.denseleznev.webstore.domain.User;
import online.denseleznev.webstore.service.ItemService;
import online.denseleznev.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/searchByCategory")
	public String searchByCategory(
			@RequestParam("category") String category,
			Model model, Principal principal
			){
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String classActiveCategory = "active"+category;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		classActiveCategory = classActiveCategory.replaceAll("&", "");
		model.addAttribute(classActiveCategory, true);
		
		List<Item> itemList = itemService.findByCategory(category);
		
		if (itemList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "show";
		}
		
		model.addAttribute("itemList", itemList);
		
		return "show";
	}
	
	@RequestMapping("/searchItem")
	public String searchItem(
			@ModelAttribute("keyword") String keyword,
			Principal principal, Model model
			) {
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		List<Item> itemList = itemService.blurrySearch(keyword);
		
		if (itemList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "show";
		}
		
		model.addAttribute("itemList", itemList);
		
		return "show";
	}
}
