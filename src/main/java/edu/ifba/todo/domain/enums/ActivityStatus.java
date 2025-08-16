package edu.ifba.todo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActivityStatus {

  TODO("Para Fazer"),
  DOING("Fazendo"),
  DONE("Feito");

  private String viewName;

}
