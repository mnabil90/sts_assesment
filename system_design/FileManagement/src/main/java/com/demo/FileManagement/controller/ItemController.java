package com.demo.FileManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FileManagement.dto.ResponseMessage;
import com.demo.FileManagement.model.Item;
import com.demo.FileManagement.service.ItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("item")
@AllArgsConstructor
public class ItemController {

	private final ItemService itemService;
	
	@PostMapping("/createSpace")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage createSpace(@RequestBody Item item){
		return itemService.createSpace(item);
	}
	
	@PostMapping("/createFolder")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage createFolder(@RequestBody Item item){
		return itemService.createFolder(item);
	}
}
