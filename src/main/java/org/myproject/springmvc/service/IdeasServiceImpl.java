package org.myproject.springmvc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.myproject.springmvc.dao.IdeasDAO;
import org.myproject.springmvc.dto.IdeaDTO;
import org.myproject.springmvc.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;

public class IdeasServiceImpl implements IdeasService {
	
	@Autowired
	IdeasDAO ideasDAO;

	@Override
	public int add(IdeaDTO ideaDTO) {
		return ideasDAO.add(convert(ideaDTO));
	}

	@Override
	public int update(IdeaDTO ideaDTO) {
		return ideasDAO.update(convert(ideaDTO));
	}

	@Override
	public int delete(int id) {
		return ideasDAO.delete(id);
	}

	@Override
	public IdeaDTO get(int id) {
		return convert(ideasDAO.get(id));
	}

	@Override
	public List<IdeaDTO> list() {
		return ideasDAO.list().stream().map(IdeasServiceImpl :: convert).collect(Collectors.toList());
	}
	
	private static Idea convert(IdeaDTO ideaDTO) {
		Idea ideaModel = new Idea();
		ideaModel.setId(ideaDTO.getId());
		ideaModel.setCaption(ideaDTO.getCaption());
		ideaModel.setContent(ideaDTO.getContent());
		ideaModel.setLikes(ideaDTO.getLikes());
		ideaModel.setDislikes(ideaDTO.getDislikes());
		return ideaModel;
	}
	
	private static IdeaDTO convert(Idea ideaModel) {
		IdeaDTO ideaDTO = new IdeaDTO();
		ideaDTO.setId(ideaModel.getId());
		ideaDTO.setCaption(ideaModel.getCaption());
		ideaDTO.setContent(ideaModel.getContent());
		ideaDTO.setLikes(ideaModel.getLikes());
		ideaDTO.setDislikes(ideaModel.getDislikes());
		return ideaDTO;
	}

}
