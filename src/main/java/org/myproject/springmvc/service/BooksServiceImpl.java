package org.myproject.springmvc.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.stream.Collectors;

import org.myproject.springmvc.dao.BooksDAO;
import org.myproject.springmvc.dto.BooksDTO;
import org.myproject.springmvc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("booksService")
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	BooksDAO booksDAO;

	@Override
	public int add(BooksDTO booksDTO) {
		return booksDAO.add(convert(booksDTO));
	}

	@Override
	public int update(BooksDTO booksDTO) {
		return booksDAO.update(convert(booksDTO));
	}

	@Override
	public int delete(int id) {
		return booksDAO.delete(id);
	}

	@Override
	public BooksDTO get(int id) {
		return convert(booksDAO.get(id));
	}

	@Override
	public List<BooksDTO> list() {
		return booksDAO.list().stream().map(BooksServiceImpl :: convert).collect(Collectors.toList());
	}
	
	private static Book convert(BooksDTO booksDTO) {
		Book bookModel = new Book();
		bookModel.setId(booksDTO.getId());
		bookModel.setTitle(booksDTO.getTitle());
		bookModel.setAuthor(booksDTO.getAuthor());
		bookModel.setDescription(booksDTO.getDescription());
		bookModel.setImage(booksDTO.getImage());
		return bookModel;
	}
	
	private static BooksDTO convert(Book bookModel) {
		BooksDTO booksDTO = new BooksDTO();
		booksDTO.setId(bookModel.getId());
		booksDTO.setTitle(bookModel.getTitle());
		booksDTO.setAuthor(bookModel.getAuthor());
		booksDTO.setDescription(bookModel.getDescription());
		booksDTO.setImage(bookModel.getImage());
		booksDTO.setRating(bookModel.getRating());
		return booksDTO;
	}

	@Override
	public List<BooksDTO> listBySearchingName(String bookName) {
		return booksDAO.listBySearchingName(bookName).stream().map(BooksServiceImpl :: convert).collect(Collectors.toList());
	}

	@Override
	public void rateBook(int bookId, int bookEvaluation) {
		Book book = booksDAO.get(bookId);
		book.setEvaluationSum(book.getEvaluationSum() + bookEvaluation);
		book.setEvaluationQuant(book.getEvaluationQuant() + 1);
		book.setRating(book.getEvaluationSum()/book.getEvaluationQuant());
		booksDAO.update(book);
	}

}
