package edu.ifba.todo.mapping;

import org.mapstruct.Mapper;

import edu.ifba.todo.dto.ActivityDTO;
import edu.ifba.todo.entity.ActivityEntity;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

  public ActivityEntity toActivityEntity(ActivityDTO dto);

  public ActivityDTO toActivityDTO(ActivityEntity entity);

}
