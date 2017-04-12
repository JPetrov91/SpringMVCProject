package org.myproject.springmvc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	//FK User-id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User author;
	//FK book-id
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column
	private Date date;
	
	@Column
	private int likes;
	
	@Column
	private int dislikes;

}
