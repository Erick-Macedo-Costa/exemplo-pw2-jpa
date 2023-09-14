package com.example.mapeamento.mapeamento.controller;

import com.example.mapeamento.mapeamento.model.entity.Paciente;
import com.example.mapeamento.mapeamento.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    PacienteRepository repository;
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pacientes", repository.pacientes());
        return new ModelAndView("/paciente/list", model);
    }
    @GetMapping("/consulta/{id}")
    public ModelAndView consulta(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consultas", repository.paciente(id));
        return new ModelAndView("/paciente/list", model);
    }
}
