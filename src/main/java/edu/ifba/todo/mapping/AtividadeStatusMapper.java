package edu.ifba.todo.mapping;

import org.mapstruct.Mapper;

import edu.ifba.todo.domain.dto.AtividadeStatusDTO;
import edu.ifba.todo.domain.entity.AtividadeStatusEntity;

@Mapper(componentModel = "spring")
public interface AtividadeStatusMapper {

  AtividadeStatusDTO toDto(AtividadeStatusEntity src);

  AtividadeStatusEntity toEntity(AtividadeStatusDTO src);

}
