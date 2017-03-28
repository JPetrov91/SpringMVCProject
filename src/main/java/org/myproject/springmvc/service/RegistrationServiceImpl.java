package org.myproject.springmvc.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;

import org.hibernate.dialect.DataDirectOracle9Dialect;
import org.myproject.springmvc.dao.IdeasDAO;
import org.myproject.springmvc.dto.RegistrationUserDTO;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private IdeasDAO dao;
	
	@Override
	public RegistrationStatus register(RegistrationUserDTO userDTO) {
		try {
		User user = new User();
		user.setEmail(userDTO.getLogin());
		String salt = generateSalt(20);
		user.setSalt(salt);
		byte[] hashPassword = hash(salt + userDTO.getPassword());
		user.setPassword(hashPassword);
		boolean registerResult = dao.registerUser(user);
		if (registerResult) {
			return RegistrationStatus.OK;
		} else {
			return RegistrationStatus.DB_ERROR;
		}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return RegistrationStatus.SERVER_ERROR;
		}
	}

	private byte[] hash(String fullPassword) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(fullPassword.getBytes());
		byte[] result = messageDigest.digest();
		return result;
	}

	private String generateSalt(int length) throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[length];
		secureRandom.nextBytes(salt);
		return DatatypeConverter.printBase64Binary(salt);
	}

	@Override
	public boolean isUserExists(String login) {
		return dao.isUserExists(login);
	}
}
