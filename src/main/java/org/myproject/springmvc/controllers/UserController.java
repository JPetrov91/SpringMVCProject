package org.myproject.springmvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.myproject.springmvc.dto.BooksDTO;
import org.myproject.springmvc.model.User;
import org.myproject.springmvc.service.BooksService;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private BooksService booksService;
	
	//TODO: IMPORTANT! To figure out with this 
	//Responds only for login function. If receives error - display it on login form(login.jsp). Also receives a request
	//But a little unclear - where some manipulation with User model? He didnt receives user model or its going on
	//Security??
	//Ok. Login and password Handles Security Handler. But where data goes after that?
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(error);
		if (error != null) {
			modelAndView.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		if (logout != null) {
			modelAndView.addObject("msg", "You've been logged out succesfully.");
		}
		//modelMap.addAttribute("")
		
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	//Get request on registration page, and returns registration form on this page
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register_form");
		modelAndView.getModelMap().addAttribute("user", new User());
		return modelAndView;
	}
	
	//Gets Registration form from page, when users press submit. Validate it, and if all is ok - receives data
	// in userService ... and securityService do autologin
	@RequestMapping(value = "registrationSubmit", method = RequestMethod.POST)
	public String register(@ModelAttribute User user, BindingResult bindingResult, Model model) {
		userValidator.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.save(user);
		securityService.autologin(user.getUsername(), user.getConfirmPassword());
		return "redirect:/welcome";
	}
	
	//Method for Error message on login page
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
	
	//Mapping for Profile Editor
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editProfile(@RequestParam long id) {
		ModelAndView modelAndView = new ModelAndView("editProfile");
		User user = userService.getById(id);
		modelAndView.getModelMap().addAttribute("editedUser", user);
		return modelAndView;
	}
	
	@RequestMapping(value = "/editAction")
	public ModelAndView editAction(@ModelAttribute User editedUser) {
		userService.update(editedUser);
		return new ModelAndView("redirect:books");
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
	
	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView("welcome");
		return modelAndView;
	}
	
	
	/*-----------------ADMIN PANEL PAGES------------------------- */
	
	
	@RequestMapping(value = "/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin/main");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/users")
	public ModelAndView adminEditUsers() {
		ModelAndView modelAndView = new ModelAndView("admin/users");
		List<User> usersList = userService.list();
		modelAndView.getModelMap().addAttribute("usersList",usersList);
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/books")
	public ModelAndView adminEditBooks() {
		ModelAndView modelAndView = new ModelAndView("admin/books");
		List<BooksDTO> booksList = booksService.list();
		modelAndView.getModelMap().addAttribute("booksList", booksList);
		return modelAndView;
	}
}
