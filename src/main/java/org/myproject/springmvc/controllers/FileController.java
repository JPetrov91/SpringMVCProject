package org.myproject.springmvc.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	private static Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		
		String name = null;
		
		if (!(file.isEmpty())) {
			try {
			byte[] bytes = file.getBytes();
			name = file.getOriginalFilename();
			String rootPath = "C:\\Users\\jurijs.petrovs\\workspace\\SpringMVCProject\\src\\main\\webapp\\resources\\img";
			File dir = new File(rootPath + File.separator + "tmpFiles");
			logger.info("Trying to save into" + rootPath);
			if (!(dir.exists())) {
				dir.mkdirs();
				logger.info("Directory doesnt exists");
			}
			
			File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
			bufferedOutputStream.write(bytes);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
			logger.info("uploaded: " + uploadedFile.getAbsolutePath());
			return "You succesfully uploaded file " + name;
			}catch (Exception e) {
				return "You failed to upload " + name + " " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file is empty";
		}
	}
}
