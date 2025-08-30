package edu.ifba.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ifba.todo.domain.dto.AtividadeDTO;
import edu.ifba.todo.exceptions.NotFoundException;
import edu.ifba.todo.mapping.AtividadeMapper;
import edu.ifba.todo.repository.ActivityRepository;
import edu.ifba.todo.repository.ActivityStatusRepository;
import edu.ifba.todo.service.AtividadeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtividadeServiceImpl implements AtividadeService {

  private final ActivityRepository repository;
  private final ActivityStatusRepository statusRepository;
  private final AtividadeMapper mapper;

  @Override
  public List<AtividadeDTO> findAll() {
    return repository.findByStatus(List.of(1L, 2L))
              .stream()
              .map(mapper::toActivityDTO)
              .toList();
  }

  @Override
  public AtividadeDTO findOne(Long id) {
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
  public AtividadeDTO save(AtividadeDTO noteDTO) {
    var status = statusRepository.findById(noteDTO.getStatus().getId()).orElseThrow();
    var entity = repository.save(mapper.toActivityEntity(noteDTO, status));
    return mapper.toActivityDTO(entity);
  }

  

}
