package edu.ifba.todo.controller;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ifba.todo.dto.ActivityDTO;
import edu.ifba.todo.exceptions.NotFoundException;
import edu.ifba.todo.service.ActivityService;
import edu.ifba.todo.service.ActivityStatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/atividade")
@RequiredArgsConstructor
@Slf4j
public class ActivityController {

  private final ActivityService service;
  private final ActivityStatusService statusService;

  @PostMapping
  public String create(@Valid @ModelAttribute("activity") ActivityDTO activity, BindingResult result, Model model) {
    log.info("Request: {} {}", activity, result.hasErrors());
    if (result.hasErrors()) {
      loadFormData(model);
      model.addAttribute("activity", activity);
      return "atividades/list-all";
    }
    service.save(activity);
    return "redirect:/atividade";
    
  }

  @GetMapping("/excluir/{id}")
  public String excluir(@PathVariable("id") Long id) {
      service.remove(id);
      return "redirect:/atividade";
  }
  
  @GetMapping("/editar/{id}")
  public String carregaFormEdicao(@PathVariable("id") Long id, Model model) {
    loadFormData(model);
    try {
      var activity = service.findOne(id);
      model.addAttribute("activity", activity);
    } catch (NotFoundException e) {
      model.addAttribute("erroNotFound", true);
    }
    
    return "atividades/list-all";
  }

  @GetMapping
  public String listAll(Model model) {
    loadFormData(model);
    return "atividades/list-all";
  }

  private void loadFormData(Model model) {
    model.addAttribute("atividades", service.findAll());
    model.addAttribute("listStatus", statusService.findAll());
    model.addAttribute("activity", new ActivityDTO());
  }

  @GetMapping("/{id}")
  public ModelAndView findById(@PathVariable("id") Long id) {
    return null;
  }

}
