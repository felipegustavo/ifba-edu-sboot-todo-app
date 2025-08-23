package edu.ifba.todo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityStatusDTO {

  @NotNull
  private Long id;
  
  private String name;

}
