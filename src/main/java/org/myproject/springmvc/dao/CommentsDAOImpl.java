package org.myproject.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.Comment;
import org.myproject.springmvc.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Repository
public class CommentsDAOImpl implements CommentsDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public void add(Comment comment) {
		Session session = sessionFactory.openSession();
		session.save(comment);
		session.close();
	}

	@Transactional
	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Comment comment = (Comment) session.get(Comment.class, id);
		session.delete(comment);
		session.flush();
		session.close();
	}

	@Override
	public Comment get(int id) {
		Session session = sessionFactory.openSession();
		Comment comment = (Comment) session.get(Comment.class, id);
		session.close();
		return comment;
	}

	@Override
	public List<Comment> list() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Comment> list = session.createQuery("from Comment").list();
        session.close();
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listByBook(int bookId) {
		Session session = sessionFactory.openSession();
		List<Comment> commentsList = new ArrayList<>();
		String queryString = "from Comment where book_id = :bookId";
		Query query = session.createQuery(queryString);
		query.setParameter("bookId", bookId);
		commentsList = query.list();
		return commentsList;
	}

}
