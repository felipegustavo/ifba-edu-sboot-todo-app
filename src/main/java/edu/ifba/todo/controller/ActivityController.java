package edu.ifba.todo.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ifba.todo.dto.ActivityDTO;
import edu.ifba.todo.service.ActivityService;
import edu.ifba.todo.service.ActivityStatusService;
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
  public String create(ActivityDTO dto) {
    log.info("Request: {}", dto);
    service.save(dto);
    return "redirect:/atividade";
  }

  @GetMapping
  public String listAll(Model model) {
    model.addAttribute("atividades", service.findAll());
    model.addAttribute("listStatus", statusService.findAll());
    return "atividades/list-all";
  }

  @GetMapping("/{id}")
  public ModelAndView findById(@PathVariable("id") Long id) {
    return null;
  }

}
