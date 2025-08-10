package edu.ifba.todo.service;

import java.util.List;

import edu.ifba.todo.dto.NoteDTO;

public interface NoteService {

  NoteDTO save(NoteDTO noteDTO);
  NoteDTO findOne(Long id);
  List<NoteDTO> findAll();
  void remove(Long id);

}
