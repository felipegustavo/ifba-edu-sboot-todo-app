package edu.ifba.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import edu.ifba.todo.entity.ActivityEntity;

import java.util.List;
import java.util.Optional;


public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

  // ver mais: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  Optional<ActivityEntity> findOneByTitle(String title);

  @Query("select ae from ActivityEntity ae where ae.status.id in (:statusId)")
  List<ActivityEntity> findByStatus(List<Long> statusId);

  @NativeQuery("select * from TB_ATIVIDADE where STATUS_ID in (:statusId)")
  List<ActivityEntity> findByStatus2(List<Long> statusId);



}
