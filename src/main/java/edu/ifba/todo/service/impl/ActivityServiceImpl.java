package edu.ifba.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ifba.todo.dto.ActivityDTO;
import edu.ifba.todo.mapping.ActivityMapper;
import edu.ifba.todo.repository.ActivityRepository;
import edu.ifba.todo.service.ActivityService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

  private final ActivityRepository repository;
  private final ActivityMapper mapper;

  @Override
  public List<ActivityDTO> findAll() {
    return repository.findAll()
              .stream()
              .map(mapper::toActivityDTO)
              .toList();

    /*List<NoteDTO> result = new ArrayList<>();
    for (var elem : repository.findAll()) {
      if (elem.getTitle().startsWith("A")) {
        result.add(mapper.tNoteDTO(elem));
      }
    }
    return result;*/
  }

  @Override
  public ActivityDTO findOne(Long id) {
    var entity = repository.findById(id).orElseThrow();
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
    var entity = repository.save(mapper.toActivityEntity(noteDTO));
    return mapper.toActivityDTO(entity);
  }

  

}
