package com.demo.FileManagement.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
