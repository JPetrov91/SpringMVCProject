package org.myproject.springmvc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.myproject.springmvc.dao.BooksDAO;
import org.myproject.springmvc.dto.BooksDTO;
import org.myproject.springmvc.dto.IdeaDTO;
import org.myproject.springmvc.model.Book;
import org.myproject.springmvc.model.Idea;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
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
		return booksDTO;
	}

}
