package edu.ifba.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifba.todo.domain.entity.AtividadeStatusEntity;

public interface ActivityStatusRepository extends JpaRepository<AtividadeStatusEntity, Long>  {

}
