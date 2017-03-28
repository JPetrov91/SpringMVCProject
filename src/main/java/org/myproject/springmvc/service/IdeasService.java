package org.myproject.springmvc.service;

import java.util.List;

import org.myproject.springmvc.dto.IdeaDTO;
import org.myproject.springmvc.model.Idea;

public interface IdeasService {

	
	int add(IdeaDTO ideaDTO);
	
	int update(IdeaDTO ideaDTO);
	
	int delete(int id);
	
	IdeaDTO get(int id);
	
	List<IdeaDTO> list();
}
