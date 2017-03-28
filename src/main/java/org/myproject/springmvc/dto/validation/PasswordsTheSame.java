package org.myproject.springmvc.dto.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordsTheSameValidator.class)
public @interface PasswordsTheSame {
	
	String message() default "Passwords does not match";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
}
