package com.example.demo.Files;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	@Autowired
	FileService fs;
	@PostMapping("upload")
	public String uploadfile(@RequestParam("file")MultipartFile file) {
		try {
            String fileName = file.getOriginalFilename();
            byte[] fileData = file.getBytes();
            fs.uploadFile(fileName, fileData);
            return "File uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
	}

}
