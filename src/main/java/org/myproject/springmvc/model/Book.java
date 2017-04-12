package org.myproject.springmvc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column
	private String image;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column
	private int evaluationSum;
	
	@Column
	private int evaluationQuant;
	
	@Column
	private double rating;
	
	@OneToMany(mappedBy = "book")
	private List<Comment> comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getEvaluationSum() {
		return evaluationSum;
	}

	public void setEvaluationSum(int evaluationSum) {
		this.evaluationSum = evaluationSum;
	}

	public int getEvaluationQuant() {
		return evaluationQuant;
	}

	public void setEvaluationQuant(int evaluationQuant) {
		this.evaluationQuant = evaluationQuant;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
