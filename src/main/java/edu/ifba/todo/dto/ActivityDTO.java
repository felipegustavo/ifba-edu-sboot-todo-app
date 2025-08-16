package edu.ifba.todo.dto;

import edu.ifba.todo.domain.enums.ActivityStatus;

public record ActivityDTO(Long id, String title, String description, ActivityStatus status) {

}
