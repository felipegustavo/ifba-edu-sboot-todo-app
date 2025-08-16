package edu.ifba.todo.mapping;

import org.springframework.stereotype.Component;

import edu.ifba.todo.dto.ActivityDTO;
import edu.ifba.todo.entity.ActivityEntity;

@Component
public class ActivityMapper {

  public ActivityEntity toActivityEntity(ActivityDTO dto) {
    return new ActivityEntity(dto.id(), dto.title(), dto.description(), dto.status());
  }

  public ActivityDTO toActivityDTO(ActivityEntity entity) {
    return new ActivityDTO(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getStatus());
  }

}
