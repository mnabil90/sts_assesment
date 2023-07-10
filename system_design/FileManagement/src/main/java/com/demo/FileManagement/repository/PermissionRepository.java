package com.demo.FileManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.FileManagement.model.Permission;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, String> {

	public List<Permission> findByUserEmail(String userEmail);
}
