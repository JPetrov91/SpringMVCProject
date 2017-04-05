package org.myproject.springmvc.controllers;

import java.util.List;

import org.myproject.springmvc.dto.IdeaDTO;
import org.myproject.springmvc.model.Idea;
import org.myproject.springmvc.service.IdeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IdeasController {
	
	@Autowired
	@Qualifier("ideasService")
	IdeasService ideasService;
	
	@RequestMapping(value="/ideas",  method=RequestMethod.GET)
	public String ideas(ModelMap map) {
		List<IdeaDTO> list = ideasService.list();
		map.addAttribute("list", list);
		return "ideas";
	}
	
	@RequestMapping(value="/idea")
	public String idea(ModelMap map) {
		List<IdeaDTO> list = ideasService.list();
		map.addAttribute("list", list);
		return "idea";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createNewForm() {
		ModelAndView modelAndView = new ModelAndView("addForm");
		modelAndView.getModelMap().addAttribute("newIdea", new IdeaDTO());
		return modelAndView;
	}
	
	@RequestMapping(value="/submitNew", method=RequestMethod.POST)
	public ModelAndView createNewAction(@ModelAttribute IdeaDTO newIdea) {
		ideasService.add(newIdea);
		return new ModelAndView("redirect:ideas");
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView deleteIdea(@RequestParam int id) {
		ideasService.delete(id);
		return new ModelAndView("redirect:ideas");
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("updateForm");
		modelAndView.getModelMap().addAttribute("newIdea", ideasService.get(id));
		return modelAndView;
	}
	
	@RequestMapping(value="/submitUpdate", method=RequestMethod.POST)
	public ModelAndView updateAction(@ModelAttribute IdeaDTO newIdea) {
		ideasService.update(newIdea);
		return new ModelAndView("redirect:ideas");
	}

//	private Idea generateRandomIdea() {
//		Random random = new Random();
//		Idea idea = new Idea();
//		idea.setLikes(random.nextInt(100));
//		idea.setDislikes(random.nextInt(100));
//		idea.setCaption(generateString(random, 50));
//		idea.setContent(generateString(random, 200));
//		return idea;
//	}
//
//	private String generateString(Random random, int max) {
//		int length = random.nextInt(max - 10) + 10;
//		StringBuilder stringBuilder = new StringBuilder();
//		for(int i =0; i < length; i++) {
//			stringBuilder.append((char)(random.nextInt(26) + 97));
//			
//			if(i % 10 == 9) {
//				stringBuilder.append(" ");
//			}
//		}
//		return stringBuilder.toString();
//	}
}
