package edu.ifba.todo.mapping;

import org.mapstruct.Mapper;

import edu.ifba.todo.dto.ActivityStatusDTO;
import edu.ifba.todo.entity.ActivityStatusEntity;

@Mapper(componentModel = "spring")
public interface ActivityStatusMapper {

  ActivityStatusDTO toDto(ActivityStatusEntity src);

  ActivityStatusEntity toEntity(ActivityStatusDTO src);

}
