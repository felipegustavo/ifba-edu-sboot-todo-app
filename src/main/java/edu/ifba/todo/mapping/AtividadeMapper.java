package edu.ifba.todo.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.ifba.todo.domain.dto.AtividadeDTO;
import edu.ifba.todo.domain.entity.AtividadeEntity;
import edu.ifba.todo.domain.entity.AtividadeStatusEntity;

@Mapper(componentModel = "spring")
public interface AtividadeMapper {

  @Mapping(target = "id", source = "dto.id")
  public AtividadeEntity toActivityEntity(AtividadeDTO dto, AtividadeStatusEntity status);

  public AtividadeDTO toActivityDTO(AtividadeEntity entity);

}
