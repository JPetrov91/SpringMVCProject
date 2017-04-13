package org.myproject.springmvc.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.myproject.springmvc.dao.BooksDAO;
import org.myproject.springmvc.dao.CommentsDAO;
import org.myproject.springmvc.dao.UserDAO;
import org.myproject.springmvc.model.Book;
import org.myproject.springmvc.model.Comment;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	CommentsDAO commentsDao;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	BooksDAO booksDao;

	@Override
	public void add(Comment comment, int bookId, int userId) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		comment.setPublicationDate(dateFormat.format(date));
		User user = userDao.getById(userId);
		Book book = booksDao.get(bookId);
		comment.setAuthor(user);
		comment.setBook(book);
		commentsDao.add(comment);
	}

	@Override
	public void delete(int id) {
		commentsDao.delete(id);
	}

	@Override
	public Comment get(int id) {
		return commentsDao.get(id);
	}

	@Override
	public List<Comment> list() {
		return commentsDao.list();
	}

	@Override
	public List<Comment> listByBook(int bookId) {
		return commentsDao.listByBook(bookId);
	}

}
