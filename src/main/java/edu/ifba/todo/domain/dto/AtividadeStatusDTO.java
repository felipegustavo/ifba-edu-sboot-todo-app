package edu.ifba.todo.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeStatusDTO {

  @NotNull
  private Long id;
  
  private String nome;

}
