package org.myproject.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.myproject.springmvc.model.User;
import org.myproject.springmvc.service.SecurityService;
import org.myproject.springmvc.service.UserService;
import org.myproject.springmvc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
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
	
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register_form");
		modelAndView.getModelMap().addAttribute("userForm", new User());
		return modelAndView;
	}
	
	@RequestMapping(value = "registrationSubmit", method = RequestMethod.POST)
	public String register(@ModelAttribute User userFrom, BindingResult bindingResult, Model model) {
		userValidator.validate(userFrom, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.save(userFrom);
		securityService.autologin(userFrom.getUsername(), userFrom.getConfirmPassword());
		return "redirect:/welcome";
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
