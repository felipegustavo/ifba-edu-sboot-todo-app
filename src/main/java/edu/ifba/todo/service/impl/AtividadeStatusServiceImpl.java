package edu.ifba.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ifba.todo.domain.dto.AtividadeStatusDTO;
import edu.ifba.todo.domain.entity.AtividadeStatusEntity;
import edu.ifba.todo.mapping.AtividadeStatusMapper;
import edu.ifba.todo.repository.ActivityStatusRepository;
import edu.ifba.todo.service.AtividadeStatusService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtividadeStatusServiceImpl implements AtividadeStatusService {

  private final ActivityStatusRepository repository;
  private final AtividadeStatusMapper mapper;

  @Override
  public List<AtividadeStatusDTO> findAll() {
    return repository
            .findAll()
            .stream()
            .map(mapper::toDto)
            .toList();
  }


  

}
