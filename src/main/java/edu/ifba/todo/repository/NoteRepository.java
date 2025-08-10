package edu.ifba.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifba.todo.entity.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
