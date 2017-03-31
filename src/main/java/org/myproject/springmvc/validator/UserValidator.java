package org.myproject.springmvc.validator;

import org.myproject.springmvc.model.User;
import org.myproject.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors arg1) {
		User user = (User)object;
		
	}

}
