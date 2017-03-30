package org.myproject.springmvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account")
@NamedQuery(name = User.SELECT_USER_COUNT_BY_LOGIN, query = "select count(id) from User where email=:login")
public class User {
	
	public static final String SELECT_USER_COUNT_BY_LOGIN = "select_user_count_by_login";
	
	public User() {
		
	}
	
	public User(String email, String password, boolean enabled) {
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}
	
	public User(String email, String password, boolean enabled, Set<UserRole> userRoles) {
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "email", nullable = false, unique = true, length = 45)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Column(name = "password", nullable = false, length = 60)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
