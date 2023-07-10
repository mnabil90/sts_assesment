package com.demo.FileManagement.model;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "permission")
@Data
public class Permission {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  
  private String userEmail;
  
  private String permissionLevel;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_id")
  private PermissionGroup group;
  
}
