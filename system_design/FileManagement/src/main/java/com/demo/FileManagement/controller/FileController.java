package com.demo.FileManagement.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.FileManagement.dto.ResponseMessage;
import com.demo.FileManagement.model.FileDB;
import com.demo.FileManagement.service.FlieService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("file")
@AllArgsConstructor
public class FileController {

	private final FlieService fileService; 
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage uploadFile(@RequestParam("file") MultipartFile file,@RequestParam String itemId,@RequestParam String userEmail) {
		return fileService.uploadFile(file,itemId,userEmail);
    }
	
  @GetMapping("/download")
  public ResponseEntity<byte[]> getFile(@RequestParam String id,@RequestParam String userEmail) {
    FileDB fileDB = fileService.getFile(id,userEmail);
    if(fileDB != null) {
    	return ResponseEntity.ok()
    	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFileName() + "\"")
    	        .body(fileDB.getData());	
    }else {
    	return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
    }
  }
  
  @GetMapping("/getFileInfo")
  @ResponseStatus(HttpStatus.OK)
  public ResponseMessage getFileInfo(@RequestParam String id,@RequestParam String userEmail) {
		return fileService.getFileInfo(id,userEmail);
  }

}
