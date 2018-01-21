package online.denseleznev.webstore.service;

import online.denseleznev.webstore.domain.ShippingAddress;
import online.denseleznev.webstore.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
