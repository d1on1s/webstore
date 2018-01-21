package online.denseleznev.webstore.service;

import online.denseleznev.webstore.domain.BillingAddress;
import online.denseleznev.webstore.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
