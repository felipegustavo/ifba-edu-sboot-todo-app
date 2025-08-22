package edu.ifba.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ifba.todo.dto.ActivityStatusDTO;
import edu.ifba.todo.entity.ActivityStatusEntity;
import edu.ifba.todo.mapping.ActivityStatusMapper;
import edu.ifba.todo.repository.ActivityStatusRepository;
import edu.ifba.todo.service.ActivityStatusService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityStatusServiceImpl implements ActivityStatusService {

  private final ActivityStatusRepository repository;
  private final ActivityStatusMapper mapper;

  @Override
  public List<ActivityStatusDTO> findAll() {
    return repository
            .findAll()
            .stream()
            .map(mapper::toDto)
            .toList();
  }


  

}
