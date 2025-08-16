package edu.ifba.todo.service;

import java.util.List;

import edu.ifba.todo.dto.ActivityDTO;

public interface ActivityService {

  ActivityDTO save(ActivityDTO noteDTO);
  ActivityDTO findOne(Long id);
  List<ActivityDTO> findAll();
  void remove(Long id);

}
