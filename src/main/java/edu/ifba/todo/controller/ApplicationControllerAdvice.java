package edu.ifba.todo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler({IllegalArgumentException.class})
  public ModelAndView handleIllegalArgumentException(IllegalArgumentException ex) {
    return new ModelAndView("error2");
  }

  
}
