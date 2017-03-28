package org.myproject.springmvc.service;

import org.myproject.springmvc.dto.RegistrationUserDTO;

public interface RegistrationService {
	
	public enum RegistrationStatus {
		OK, VALIDATION_ERROR, DUPLICATE, DB_ERROR, SERVER_ERROR
	}
	
	public RegistrationStatus register(RegistrationUserDTO userDTO);

	public boolean isUserExists(String login);
}
