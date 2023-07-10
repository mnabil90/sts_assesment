package com.demo.FileManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FileManagement.dto.ResponseMessage;
import com.demo.FileManagement.model.PermissionGroup;
import com.demo.FileManagement.service.PermissionGroupService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("permissiongroup")
@AllArgsConstructor
public class PermissionGroupController {
	
	private final PermissionGroupService permissionGroupService;
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage save(@RequestBody PermissionGroup group){
		return permissionGroupService.save(group);
	}
	
	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage findAll(){
		return permissionGroupService.findAll();
	}
}
