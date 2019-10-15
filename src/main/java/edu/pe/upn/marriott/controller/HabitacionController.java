package edu.pe.upn.marriott.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.TipoService;


@Controller
@RequestMapping("/Habitacion")
@SessionAttributes("/Habitacion")
public class HabitacionController {
	@Autowired
    private HabitacionService habitacionservice;
	
	@Autowired
    private TipoService tiposervice;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Habitacion> habitacion = habitacionservice.findAll();
			model.addAttribute("habitacion", habitacion);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Habitacion/Inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> optional = habitacionservice.findById(id);
			if (optional.isPresent()) {
				
				List<Tipo> especialidades 
					= tiposervice.findAll(); 
				
				model.addAttribute("habitacion", optional.get());
				model.addAttribute("tipo", especialidades);
			} else {
				return "redirect:/Habitacion";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/Habitacion/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("habitacion") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionservice.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/Habitacion";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion = new Habitacion();
		model.addAttribute("medico", habitacion);
		try {
			List<Tipo> tipo = 
					tiposervice.findAll();
			model.addAttribute("tipo", tipo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Habitacion/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> medico = habitacionservice.findById(id);
			if(medico.isPresent()) {
				habitacionservice.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Habitacion> habitacion = habitacionservice.findAll();
				model.addAttribute("medicos", habitacion);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/Habitacion/Inicio";
		}
		return "redirect:/Habitacion";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> medico = habitacionservice.findById(id);
			if(medico.isPresent()) {
				model.addAttribute("habitacion", medico.get());
			} else {
				return "redirect:/Habitacion";
			}
		} catch (Exception e) {

		}	
		
		return "/Habitacion/info";
	}

}
