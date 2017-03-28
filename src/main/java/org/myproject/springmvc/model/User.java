package org.myproject.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="account")
@NamedQuery(name = User.SELECT_USER_COUNT_BY_LOGIN, query = "select count(id) from User where email=:login")
public class User {
	
	public static final String SELECT_USER_COUNT_BY_LOGIN = "select_user_count_by_login";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "email", columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "salt", columnDefinition = "varchar(30)", nullable = false)
	private String salt;

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Column(name = "password", columnDefinition = "BINARY(16)", nullable = false)
	private byte[] password;

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

}
