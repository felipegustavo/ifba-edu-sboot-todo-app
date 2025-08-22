package edu.ifba.todo.dto;

public record ActivityDTO(Long id,
                          String title,
                          String description,
                          ActivityStatusDTO status) {

}
