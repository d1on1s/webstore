package online.denseleznev.webstore.service.impl;

import online.denseleznev.webstore.domain.UserShipping;
import online.denseleznev.webstore.repository.UserShippingRepository;
import online.denseleznev.webstore.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShippingServiceImpl implements UserShippingService {
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	
	public UserShipping findById(Long id) {
		return userShippingRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		userShippingRepository.delete(id);
	}

}
