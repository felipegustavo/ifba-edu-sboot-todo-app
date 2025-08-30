package edu.ifba.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifba.todo.domain.dto.AtividadeDTO;
import edu.ifba.todo.exceptions.NotFoundException;
import edu.ifba.todo.service.AtividadeService;
import edu.ifba.todo.service.AtividadeStatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static edu.ifba.todo.domain.constant.PathContant.ATIVIDADE_PATH;

@Controller
@RequestMapping(ATIVIDADE_PATH)
@RequiredArgsConstructor
@Slf4j
public class AtividadeController {

  private final AtividadeService service;
  private final AtividadeStatusService statusService;

  private static final String FIELD_ACTIVITIES = "atividades";
  private static final String FIELD_LIST_STATUS = "listaStatus";
  private static final String FIELD_ACTIVITY = "atividade";

  private static final String TEMPLATE_FOLDER = "atividade/";
  private static final String PAGE_INDEX = "index";

  @PostMapping
  public String create(@Valid @ModelAttribute(FIELD_ACTIVITY) AtividadeDTO activity, BindingResult result, Model model) {
    log.info("Request: {} {}", activity, result.hasErrors());
    if (result.hasErrors()) {
      loadFormData(model);
      model.addAttribute(FIELD_ACTIVITY, activity);
      return TEMPLATE_FOLDER + PAGE_INDEX;
    }
    service.save(activity);
    return "redirect:" + ATIVIDADE_PATH;
    
  }

  @GetMapping("/excluir/{id}")
  public String excluir(@PathVariable Long id) {
      service.remove(id);
      return "redirect:" + ATIVIDADE_PATH;
  }
  
  @GetMapping("/editar/{id}")
  public String carregaFormEdicao(@PathVariable Long id, Model model) {
    loadFormData(model);
    try {
      var activity = service.findOne(id);
      model.addAttribute(FIELD_ACTIVITY, activity);
    } catch (NotFoundException _) {
      model.addAttribute("erroNotFound", true);
    }
    
    return TEMPLATE_FOLDER + PAGE_INDEX;
  }

  @GetMapping
  public String listAll(Model model) {
    loadFormData(model);
    return TEMPLATE_FOLDER + PAGE_INDEX;
  }

  private void loadFormData(Model model) {
    model.addAttribute(FIELD_ACTIVITIES, service.findAll());
    model.addAttribute(FIELD_LIST_STATUS, statusService.findAll());
    model.addAttribute(FIELD_ACTIVITY, new AtividadeDTO());
  }

}
