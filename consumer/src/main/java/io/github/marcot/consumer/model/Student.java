package io.github.marcot.consumer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable{
    private Long id;
    private String name;
    private String document;
    private Long courseId;
}
