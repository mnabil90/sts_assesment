package com.demo.FileManagement.model;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String type;
  
  private String name;
  
  @OneToOne
  @JoinColumn(name = "permission_group_id", referencedColumnName = "id")
  private PermissionGroup permissionGroup;
  
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  private Item parentItem;

  
}
