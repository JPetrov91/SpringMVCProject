package org.myproject.springmvc.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.myproject.springmvc.dto.RegistrationUserDTO;

public class PasswordsTheSameValidator implements ConstraintValidator<PasswordsTheSame, RegistrationUserDTO> {

	@Override
	public void initialize(PasswordsTheSame passwordsTheSame) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public boolean isValid(RegistrationUserDTO registrationUserDTO, ConstraintValidatorContext constraintValidatorContext) {
        return registrationUserDTO.getPassword().equals(registrationUserDTO.getRepeatPassword());
    }

}
