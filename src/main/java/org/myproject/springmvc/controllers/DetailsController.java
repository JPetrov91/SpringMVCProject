package org.myproject.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailsController {
	
	@RequestMapping(value="/details", method = RequestMethod.GET)
	public String details() {
		return "details";
	}

}
