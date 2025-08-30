package edu.ifba.todo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTO {
  
  private Long id;

  @NotBlank
  @Size(min = 10, max = 100)
  private String titulo;

  @NotBlank
  private String descricao;

  @NotNull
  private AtividadeStatusDTO status = new AtividadeStatusDTO();

}
