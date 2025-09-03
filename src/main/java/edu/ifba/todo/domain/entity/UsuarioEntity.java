package edu.ifba.todo.domain.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USUARIO")
@Data
@NoArgsConstructor
public class UsuarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String senha;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "TB_USUARIO_PAPEL",
    joinColumns = {
      @JoinColumn(name = "USUARIO_ID")
    },
    inverseJoinColumns = {
      @JoinColumn(name = "PAPEL_ID")
    })
  private List<PapelEntity> papeis;

}
