package edu.ifba.todo.service;

import java.util.List;

import edu.ifba.todo.domain.dto.AtividadeStatusDTO;

public interface AtividadeStatusService {

  List<AtividadeStatusDTO> findAll();

}
