package org.myproject.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(error);
		if (error != null) {
			modelAndView.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		if (logout != null) {
			modelAndView.addObject("msg", "You've been logged out succesfully.");
		}
		
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	private String getErrorMessage(HttpServletRequest request, String key) {
		Exception exception = (Exception) request.getSession().getAttribute(key);
		String error = "";
		
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Something goes wrong";
		}
		return error;
	}

	@RequestMapping(value = "/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView("user");
		return modelAndView;
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accessDenied() {
		ModelAndView modelAndView = new ModelAndView();
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//			System.out.println(userDetails);
//			modelAndView.addObject("username", userDetails.getUsername());
//		}
		modelAndView.setViewName("403");
		return modelAndView;
	}

}
