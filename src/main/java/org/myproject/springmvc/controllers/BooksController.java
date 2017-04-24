package org.myproject.springmvc.controllers;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.myproject.springmvc.dto.BooksDTO;
import org.myproject.springmvc.model.Book;
import org.myproject.springmvc.model.Comment;
import org.myproject.springmvc.model.Genre;
import org.myproject.springmvc.model.User;
import org.myproject.springmvc.service.BooksService;
import org.myproject.springmvc.service.CommentsService;
import org.myproject.springmvc.service.GenresService;
import org.myproject.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Security;

@Controller
@SessionAttributes("user")
public class BooksController {
	
	@Autowired
	@Qualifier(value = "booksService")
	BooksService booksService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommentsService commentsService;
	
	@Autowired
	GenresService genresService;
	
	
	@RequestMapping(value = "/")
	public ModelAndView mainPage() {
		return new ModelAndView("redirect:books"); 
	}
	
	//Method for displaying all book at page
	@RequestMapping(value = "/books")
	public ModelAndView books(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("books");
		//Getting authentication from SecurityContext, then from auth we getting User
		//But for properly working we need User Model. Need to convert from UserDetails to User
		//TODO:
		//Maybe we can create method in userDetails, which :
		//1 - we pull out username from principal\
		//2 - we get user from db by username
		//3 and we create new User with auth.username, which will be our ModelMap
		
		//Works. But only after visiting "/" page, when session gets user attribute
		//Need to change in something way.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = null;
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String userName = authentication.getName();
			user = userService.findByUsername(userName);
			modelAndView.addObject("user", user);
		}
		List<BooksDTO> booksList = booksService.list();
		modelAndView.getModelMap().addAttribute("booksList", booksList);
		return modelAndView;	
	}
	
	//Method for getting book by id and do some things(update/delete) with it
//	@RequestMapping(value = "books/book", method = RequestMethod.GET)
//	public ModelAndView book(@RequestParam int id) {
//		ModelAndView modelAndView = new ModelAndView("books/book");
//		modelAndView.getModelMap().addAttribute("book", booksService.get(id));
//		modelAndView.getModelMap().addAttribute("commentsList", commentsList);
//		return modelAndView;
//	}
	
	//Method for requesting a new form for adding book
	
	@RequestMapping(value = "addBook", method = RequestMethod.GET)
	public ModelAndView addBook() {
		ModelAndView modelAndView = new ModelAndView("AddBook");
		modelAndView.getModelMap().addAttribute("newBook", new BooksDTO());
		return modelAndView;
	}
	
	//Method for adding new book into a database
	@RequestMapping(value = "addBook", params = {"save"})
	public ModelAndView submitBook(@ModelAttribute BooksDTO newBook) {
		booksService.add(newBook);
		return new ModelAndView("redirect:books");
	}
	
	//User do request by clicking on book image. BookService takes all work for taking book from DB and converting it
	//in correct format, controller puts it in ModelAndView. Must Work
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView bookProfile(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("book");
		BooksDTO book = booksService.get(id);
		List<Comment> commentsList = commentsService.listByBook(id);
		modelAndView.getModelMap().addAttribute("book", book);
		//Adding a new form for comments at book page. Maybe works
		modelAndView.getModelMap().addAttribute("comment", new Comment());
		modelAndView.getModelMap().addAttribute("commentsList", commentsList);
		return modelAndView;
	}
	
	@RequestMapping(value = "books/delete")
	public ModelAndView deleteBook(@RequestParam int id) {
		booksService.delete(id);
		return new ModelAndView("redirect:books");
	}
	
	@RequestMapping(value = "books/edit", method = RequestMethod.GET)
	public ModelAndView updateBook(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("books/edit");
		modelAndView.getModelMap().addAttribute("book", booksService.get(id));
		return modelAndView;
	}
	
	@RequestMapping(value = "books/editAction", method = RequestMethod.POST)
	public ModelAndView editAction(@ModelAttribute BooksDTO book) {
		booksService.update(book);
		return new ModelAndView("redirect:books");
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchBook(@RequestParam String bookName) {
		ModelAndView modelAndView = new ModelAndView("books");
		List<BooksDTO> booksList = booksService.listBySearchingName(bookName);
		modelAndView.getModelMap().addAttribute("booksList", booksList);
		return modelAndView;
	}
	
	@RequestMapping(value = "/ratebook")
	public ModelAndView rateBook(@RequestParam int id, int bookEvaluation, HttpServletRequest request) {
		//In this moment bookDTO is null. Why? RateFrom doesnt get Book model from Book page, but on Book page we have this Model.
		booksService.rateBook(id, bookEvaluation);
		String referer = request.getHeader("Referer");
		return new ModelAndView("redirect:" + referer);
	}
	
	@RequestMapping(value = "/submit_comment")
	public ModelAndView addComment(@ModelAttribute Comment comment, @RequestParam int bookId, int userId, HttpServletRequest request) {
		commentsService.add(comment, bookId, userId);
		String referer = request.getHeader("Referer");
		return new ModelAndView("redirect:" + referer);
	}
	
	@ModelAttribute("allGenres")
	public List<Genre> populateGenres() {
		return this.genresService.findAll();
	}
	
	@RequestMapping(value = "/addBook", params={"addGenre"})
	public String addGenre(BooksDTO booksDTO, BindingResult bindingResult) {
		booksDTO.getGenres().add(new Genre());
		return "AddBook";
	}
	
	@RequestMapping(value = "/addBook", params={"removeGenre"})
	public String removeGenre(BooksDTO booksDTO, BindingResult bindingResult, HttpServletRequest request) {
		Integer genreId = Integer.valueOf(request.getParameter("removeGenre"));
		booksDTO.getGenres().remove(genreId.intValue());
		return "AddBook";
	}

}
