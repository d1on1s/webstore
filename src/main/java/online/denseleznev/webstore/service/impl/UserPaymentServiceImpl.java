package online.denseleznev.webstore.service.impl;

import online.denseleznev.webstore.domain.UserPayment;
import online.denseleznev.webstore.repository.UserPaymentRepository;
import online.denseleznev.webstore.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	private UserPaymentRepository userPaymentRepository;
		
	public UserPayment findById(Long id) {
		return userPaymentRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		userPaymentRepository.delete(id);
	}
} 
