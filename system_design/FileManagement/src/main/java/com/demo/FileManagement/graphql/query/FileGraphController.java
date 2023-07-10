package com.demo.FileManagement.graphql.query;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.demo.FileManagement.graphql.service.FileDBService;
import com.demo.FileManagement.model.FileDB;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class FileGraphController {

	private final FileDBService fileDBService;
	
	@QueryMapping
	public FileDB getFileInfo(@Argument String id) {
        return fileDBService.getFileInfo(id);
    }
}
