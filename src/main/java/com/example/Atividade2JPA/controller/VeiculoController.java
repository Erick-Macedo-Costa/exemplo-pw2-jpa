package com.example.Atividade2JPA.controller;
import com.example.Atividade2JPA.model.entity.Veiculo;
import com.example.Atividade2JPA.model.repository.VeiculoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("veiculos")
public class VeiculoController {
    @Autowired
    VeiculoRepository repository;

    @GetMapping("/form")
    public String form(Veiculo veiculo){
        return "/veiculo/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("veiculos", repository.veiculos());
        return new ModelAndView("/veiculo/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Veiculo veiculo){
        repository.save(veiculo);
        return new ModelAndView("redirect:/veiculos/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/veiculos/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("veiculo", repository.veiculo(id));
        return new ModelAndView("/veiculo/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Veiculo veiculo) {
        repository.update(veiculo);
        return new ModelAndView("redirect:/veiculos/list");
    }

}
