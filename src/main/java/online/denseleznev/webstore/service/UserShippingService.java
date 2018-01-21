package online.denseleznev.webstore.service;

import online.denseleznev.webstore.domain.UserShipping;

public interface UserShippingService {
	UserShipping findById(Long id);
	
	void removeById(Long id);
}
