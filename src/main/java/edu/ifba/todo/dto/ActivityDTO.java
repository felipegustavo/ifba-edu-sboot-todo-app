package edu.ifba.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {
  
  private Long id;

  @NotBlank
  @Size(min = 10, max = 100)
  private String title;

  @NotBlank
  private String description;

  @NotNull
  private ActivityStatusDTO status = new ActivityStatusDTO();

}
