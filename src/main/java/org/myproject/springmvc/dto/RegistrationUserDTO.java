package org.myproject.springmvc.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.myproject.springmvc.dto.validation.PasswordsTheSame;
import org.myproject.springmvc.dto.validation.ValidEmail;

@PasswordsTheSame
public class RegistrationUserDTO {
	
	@ValidEmail
	@NotEmpty(message = "E-mail can't be empty")
	private String login;
	
	@NotEmpty(message = "Password can't be empty")
	private String password;
	private String repeatPassword;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	
}
