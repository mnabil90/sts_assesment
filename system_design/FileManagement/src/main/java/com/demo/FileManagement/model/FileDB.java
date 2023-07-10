package com.demo.FileManagement.model;



import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "files")
@Data
public class FileDB {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  
  private String fileName;
  
  private Float fileSize;

  @JsonIgnore
  @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  private Item item;

  @Lob
  @JsonIgnore
  private byte[] data;


}
