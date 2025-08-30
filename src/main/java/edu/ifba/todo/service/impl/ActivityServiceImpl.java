package edu.ifba.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ifba.todo.dto.ActivityDTO;
import edu.ifba.todo.exceptions.NotFoundException;
import edu.ifba.todo.mapping.ActivityMapper;
import edu.ifba.todo.repository.ActivityRepository;
import edu.ifba.todo.repository.ActivityStatusRepository;
import edu.ifba.todo.service.ActivityService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

  private final ActivityRepository repository;
  private final ActivityStatusRepository statusRepository;
  private final ActivityMapper mapper;

  @Override
  public List<ActivityDTO> findAll() {
    return repository.findByStatus(List.of(1L, 2L))
              .stream()
              .map(mapper::toActivityDTO)
              .toList();
  }

  @Override
  public ActivityDTO findOne(Long id) {
    var entity = repository.findById(id).orElseThrow(NotFoundException::new);
    return mapper.toActivityDTO(entity);
  }

  @Override
  public void remove(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }

  @Override
  public ActivityDTO save(ActivityDTO noteDTO) {
    var status = statusRepository.findById(noteDTO.getStatus().getId()).orElseThrow();
    var entity = repository.save(mapper.toActivityEntity(noteDTO, status));
    return mapper.toActivityDTO(entity);
  }

  

}
