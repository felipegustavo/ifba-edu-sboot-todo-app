package edu.ifba.todo.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.ifba.todo.dto.ActivityDTO;
import edu.ifba.todo.entity.ActivityEntity;
import edu.ifba.todo.entity.ActivityStatusEntity;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

  @Mapping(target = "id", source = "dto.id")
  public ActivityEntity toActivityEntity(ActivityDTO dto, ActivityStatusEntity status);

  public ActivityDTO toActivityDTO(ActivityEntity entity);

}
