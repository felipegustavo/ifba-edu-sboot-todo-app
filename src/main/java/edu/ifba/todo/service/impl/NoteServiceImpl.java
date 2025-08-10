package edu.ifba.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ifba.todo.dto.NoteDTO;
import edu.ifba.todo.mapping.NoteMapper;
import edu.ifba.todo.repository.NoteRepository;
import edu.ifba.todo.service.NoteService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

  private final NoteRepository repository;
  private final NoteMapper mapper;

  @Override
  public List<NoteDTO> findAll() {
    return repository.findAll()
              .stream()
              .filter(e -> e.getTitle().startsWith("A"))
              .map(mapper::tNoteDTO)
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
  public NoteDTO findOne(Long id) {
    var entity = repository.findById(id).orElseThrow();
    return mapper.tNoteDTO(entity);
  }

  @Override
  public void remove(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }

  @Override
  public NoteDTO save(NoteDTO noteDTO) {
    var entity = repository.save(mapper.tNoteEntity(noteDTO));
    return mapper.tNoteDTO(entity);
  }

  

}
