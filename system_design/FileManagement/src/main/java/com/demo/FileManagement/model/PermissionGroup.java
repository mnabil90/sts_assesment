package com.demo.FileManagement.model;


import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "permission_group")
@Data
public class PermissionGroup {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String groupName;
  
  @OneToMany(mappedBy = "group", fetch = FetchType.LAZY,
          cascade = CascadeType.ALL)
  private List<Permission> permissions;
}
