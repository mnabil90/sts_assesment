package com.demo.FileManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FileManagement.dto.ResponseMessage;
import com.demo.FileManagement.model.Permission;
import com.demo.FileManagement.service.PermissionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("permission")
@AllArgsConstructor
public class PermissionController {

	private final PermissionService permissionService;
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage save(@RequestBody Permission permission){
		return permissionService.save(permission);
	}
	
	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage findAll(){
		return permissionService.findAll();
	}
}
