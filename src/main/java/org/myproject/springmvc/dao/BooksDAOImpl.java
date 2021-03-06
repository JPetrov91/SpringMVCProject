package org.myproject.springmvc.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Repository
public class BooksDAOImpl implements BooksDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public int add(Book book) {
		Session session = sessionFactory.openSession();
		Serializable id = session.save(book);
		session.close();
		return (Integer) id;
	}

	@Transactional
	@Override
	public int update(Book book) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(book);
		Serializable id = session.getIdentifier(book);
		session.flush();
		session.close();
		return (Integer) id;
	}

	@Transactional
	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Book book = (Book) session.get(Book.class, id);
		session.delete(book);
		Serializable identifier = session.getIdentifier(book);
		session.flush();
		session.close();
		return (Integer) identifier;
	}

	@Override
	public Book get(int id) {
		Session session = sessionFactory.openSession();
		Book book = (Book) session.get(Book.class, id);
		session.close();
		return book;
	}

	@Override
	public List<Book> list() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Book> booksList = session.createQuery("from Book").list();
        session.close();
        return booksList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBySearchingName(String bookName) {
		Session session = sessionFactory.openSession();
		List<Book> booksList = new ArrayList<>();
		String queryString = "from Book where title like :bookName)";
		Query query = session.createQuery(queryString);
		query.setParameter("bookName", "%" + bookName + "%");
		booksList = query.list();
		return booksList;
	}

}
