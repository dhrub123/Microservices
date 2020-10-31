package com.dhruba.justgifit.controller;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Value("${spring.servlet.multipart.location}")
	private String location;
	
	@PostMapping(value="/upload", produces = MediaType.IMAGE_GIF_VALUE)
	public String upload(
			@RequestPart("file") MultipartFile file,
			@RequestParam("start") int start,
			@RequestParam("end") int end,
			@RequestParam("speed") int speed,
			@RequestParam("repeat") boolean repeat
			) {
		
		File videoFile = new File(location + "/" + System.currentTimeMillis() + ".mp4");
		try {
			file.transferTo(videoFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("Saved file to {}", videoFile.getAbsolutePath());
		return "";
	}
	
	@GetMapping(value="/getboka")
	public String getData() {
		return "soka";
	}
}
