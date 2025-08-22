package edu.ifba.todo.service;

import java.util.List;

import edu.ifba.todo.dto.ActivityStatusDTO;

public interface ActivityStatusService {

  List<ActivityStatusDTO> findAll();

}
