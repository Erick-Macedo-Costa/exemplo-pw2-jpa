package com.example.mapeamento.mapeamento.controller;

import com.example.mapeamento.mapeamento.model.repository.ConsultaRepository;
import com.example.mapeamento.mapeamento.model.repository.MedicoRepository;
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
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    ConsultaRepository repository;
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("consultas", repository.consultas());
        return new ModelAndView("/consulta/list", model);
    }

    @GetMapping("/consulta/{id}")
    public ModelAndView consulta(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consultas", repository.consultas_medico(id));
        return new ModelAndView("/consulta/list", model);
    }
}
