package edu.ifba.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_ATIVIDADE")
public class ActivityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "TITULO", nullable = false)
  private String title;

  @Column(name = "DESCRICAO", nullable = false)
  private String description;

  @ManyToOne
  @JoinColumn(name = "STATUS_ID")
  private ActivityStatusEntity status;

}
