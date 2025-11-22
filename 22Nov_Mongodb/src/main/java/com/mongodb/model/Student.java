package com.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@NotNull(message = "Roll number cannot be null")
	@Positive
    private Integer rno;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @NotNull(message = "Address cannot be null")
    @Size(min = 5, message = "Address must have at least 5 characters")
    private String address;

}
