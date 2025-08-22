package edu.ifba.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifba.todo.entity.ActivityStatusEntity;

public interface ActivityStatusRepository extends JpaRepository<ActivityStatusEntity, Long>  {

}
