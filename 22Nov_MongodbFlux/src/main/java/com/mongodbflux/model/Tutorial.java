package com.mongodbflux.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tutorial {

  @Id
  private String id;
  
  @NotNull(message="Title Can't be Null")
  @Size(min = 2, message = "Name must have at least 2 characters")
  private String title;

  @NotNull(message="Descrpition Can't be Null")
  @Size(min = 2, message = "Description must have at least 2 characters")
  private String description;

  private boolean published;

}