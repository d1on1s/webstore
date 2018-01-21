package online.denseleznev.webstore.service;

import online.denseleznev.webstore.domain.Payment;
import online.denseleznev.webstore.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
