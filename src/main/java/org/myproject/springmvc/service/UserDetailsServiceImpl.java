package org.myproject.springmvc.service;

import java.util.HashSet;
import java.util.Set;

import org.myproject.springmvc.dao.UserDAO;
import org.myproject.springmvc.model.Role;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userDAO.findByUsername(username);
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		for(Role role : user.getGroup().getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

//	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
//	}
//
//	private List<GrantedAuthority> buildUserAuthorities(Set<UserRole> userRoles) {
//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//		
//		for(UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//		}
//		
//		List<GrantedAuthority> result = new ArrayList<>(setAuths);
//		return result;
//	}

}
