package com.rem.spring.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service("fileUploadService")
public class FileUploadService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("src/main/resources/static/products");
	
	Calendar calendar = Calendar.getInstance();
	
	
	public String store(MultipartFile file){
		String nombre = calendar.get(Calendar.HOUR_OF_DAY)+""+calendar.get(Calendar.MINUTE)+""+calendar.get(Calendar.SECOND)+""+file.getOriginalFilename();
		try {
			Path urlImage = this.rootLocation.resolve(nombre);
            Files.copy(file.getInputStream(), urlImage);
            return "/products/"+nombre;
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!");
        }
	}

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
        	throw new RuntimeException("FAIL!");
        }
    }
    
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("No carga init Storage!");
        }
    }
	
	
}
