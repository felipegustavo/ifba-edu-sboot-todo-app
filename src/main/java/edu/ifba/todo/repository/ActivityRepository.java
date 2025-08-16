package edu.ifba.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifba.todo.entity.ActivityEntity;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

}
