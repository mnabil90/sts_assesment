package com.demo.FileManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.FileManagement.dto.ResponseMessage;
import com.demo.FileManagement.model.FileDB;
import com.demo.FileManagement.model.PermissionGroup;
import com.demo.FileManagement.repository.PermissionGroupRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PermissionGroupService {
	
	private final PermissionGroupRepository permissionGroupRepository;
	
	public ResponseMessage save(PermissionGroup group) {
		ResponseMessage response = new ResponseMessage();
		group = permissionGroupRepository.save(group);
		response.setSuccess(true);
		response.setData(group);
		return response;
	}
	
	public ResponseMessage findAll() {
		ResponseMessage response = new ResponseMessage();
		List<PermissionGroup> list =permissionGroupRepository.findAll();
		response.setSuccess(true);
		response.setData(list);
		return response;
	}
	
}
