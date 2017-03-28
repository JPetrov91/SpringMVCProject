package org.myproject.springmvc.controllers;

import javax.validation.Valid;

import org.myproject.springmvc.dto.RegistrationUserDTO;
import org.myproject.springmvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register_form");
		modelAndView.getModelMap().addAttribute("user", new RegistrationUserDTO());
		return modelAndView;
	}
	
	@RequestMapping(value = "register_user", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") @Valid RegistrationUserDTO userDTO, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("register_form", "user", userDTO);
		}
		if (service.isUserExists(userDTO.getLogin())) {
			result.rejectValue("login", "error.login", "User with this e-mail already exists");
		}
		service.register(userDTO);
		return new ModelAndView("redirect:ideas");
	}

}
