package online.denseleznev.webstore.service;

import online.denseleznev.webstore.domain.User;
import online.denseleznev.webstore.domain.UserBilling;
import online.denseleznev.webstore.domain.UserPayment;
import online.denseleznev.webstore.domain.UserShipping;
import online.denseleznev.webstore.domain.security.PasswordResetToken;
import online.denseleznev.webstore.domain.security.UserRole;

import java.util.Set;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User findById(Long id);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void setUserDefaultShipping(Long userShippingId, User user);
}
