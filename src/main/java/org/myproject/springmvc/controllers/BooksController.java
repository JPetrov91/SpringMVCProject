package org.myproject.springmvc.controllers;


import java.util.List;

import org.myproject.springmvc.dto.BooksDTO;
import org.myproject.springmvc.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BooksController {
	
	@Autowired
	@Qualifier(value = "booksService")
	BooksService booksService;
	
	//Method for displaying all book at page
	@RequestMapping(value = {"/books", "/"})
	public ModelAndView books() {
		ModelAndView modelAndView = new ModelAndView("books");
		List<BooksDTO> booksList = booksService.list();
		modelAndView.getModelMap().addAttribute("booksList", booksList);
		return modelAndView;	
	}
	
	//Method for getting book by id and do some things(update/delete) with it
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView book(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("book");
		modelAndView.getModelMap().addAttribute("book", booksService.get(id));
		return modelAndView;
	}
	
	//Method for requesting a new form for adding book
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public ModelAndView addBook() {
		ModelAndView modelAndView = new ModelAndView("addBook");
		modelAndView.getModelMap().addAttribute("newBook", new BooksDTO());
		return modelAndView;
	}
	
	//Method for adding new book into a database
	@RequestMapping(value = "/submitBook", method = RequestMethod.POST)
	public ModelAndView submitBook(@ModelAttribute BooksDTO newBook) {
		booksService.add(newBook);
		return new ModelAndView("redirect:books");
	}

}
