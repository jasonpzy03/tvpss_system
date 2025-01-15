package com.example.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

	@GetMapping("/images/{imageName}")
	public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
	    try {
	        // Load the image dynamically based on the URL
	        ClassPathResource resource = new ClassPathResource("static/images/" + imageName);
	        
	        // Ensure the file exists
	        if (!resource.exists()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        
	        byte[] imageData = Files.readAllBytes(resource.getFile().toPath());

	        // Set content type header based on file extension
	        String contentType = Files.probeContentType(resource.getFile().toPath());
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType(contentType));

	        // Return the image data as a ResponseEntity
	        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/images/evidences/{imageName}")
	public ResponseEntity<byte[]> getEvidence(@PathVariable String imageName) throws IOException {
	    try {
	        // Load the image dynamically based on the URL
	        ClassPathResource resource = new ClassPathResource("static/images/evidences/" + imageName);
	        
	        // Ensure the file exists
	        if (!resource.exists()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        
	        byte[] imageData = Files.readAllBytes(resource.getFile().toPath());

	        // Set content type header based on file extension
	        String contentType = Files.probeContentType(resource.getFile().toPath());
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType(contentType));

	        // Return the image data as a ResponseEntity
	        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


}