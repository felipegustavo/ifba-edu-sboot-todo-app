package edu.ifba.todo.service;

import java.util.List;

import edu.ifba.todo.domain.dto.AtividadeDTO;

public interface AtividadeService {

  AtividadeDTO save(AtividadeDTO noteDTO);
  AtividadeDTO findOne(Long id);
  List<AtividadeDTO> findAll();
  void remove(Long id);

}
