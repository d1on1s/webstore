package online.denseleznev.webstore.service;

import online.denseleznev.webstore.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);
	
	void removeById(Long id);
}
