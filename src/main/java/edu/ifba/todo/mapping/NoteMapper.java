package edu.ifba.todo.mapping;

import org.springframework.stereotype.Component;

import edu.ifba.todo.dto.NoteDTO;
import edu.ifba.todo.entity.NoteEntity;

@Component
public class NoteMapper {

  public NoteEntity tNoteEntity(NoteDTO dto) {
    return new NoteEntity(dto.id(), dto.title(), dto.body());
  }

  public NoteDTO tNoteDTO(NoteEntity entity) {
    return new NoteDTO(entity.getId(), entity.getTitle(), entity.getBody());
  }

}
