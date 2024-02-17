package io.github.marcot.studentservice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable{
    private Long id;
    private String name;
    private String document;
    private Long courseId;
}
