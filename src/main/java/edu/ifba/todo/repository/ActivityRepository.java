package edu.ifba.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import edu.ifba.todo.domain.entity.AtividadeEntity;

import java.util.List;
import java.util.Optional;


public interface ActivityRepository extends JpaRepository<AtividadeEntity, Long> {

  // ver mais: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  Optional<AtividadeEntity> findOneByTitulo(String title);

  @Query("select ae from AtividadeEntity ae where ae.status.id in (:statusId)")
  List<AtividadeEntity> findByStatus(List<Long> statusId);

  @NativeQuery("select * from TB_ATIVIDADE where STATUS_ID in (:statusId)")
  List<AtividadeEntity> findByStatus2(List<Long> statusId);



}
