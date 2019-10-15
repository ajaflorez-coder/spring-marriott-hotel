package pe.edu.upn.marriott.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.HabitacionService;

@Controller
@RequestMapping("/cliente")
public class ControllerCliente {

	@Autowired ClienteService cliente;
	@Autowired HabitacionService habitacion;
	@Autowired AlquilerService alquiler;
	@GetMapping
	public String inicio(Model model) {
		List<Cliente> lista=new ArrayList<Cliente>();
		try {
			lista = cliente.findAll();
			model.addAttribute("medicos",lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	return "/cliente/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> optional = cliente.findById(id);
			if (optional.isPresent()) {
				
			
				
				model.addAttribute("medico", optional.get());
			
			} else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/cliente/edit";
	}
	
	@PostMapping("/savepaciente")
	public String savePaciente(@ModelAttribute("paciente") Alquiler paciente, 
			Model model, SessionStatus status) {
		try {
			alquiler.save(paciente);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente";
	}
	
	
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> medico = cliente.findById(id);
			if(medico.isPresent()) {
				model.addAttribute("medico", medico.get());
			} else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {

		}	
		
		return "/cliente/info";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("medico") Cliente medico, 
			Model model, SessionStatus status) {
		try {
			
			cliente.save(medico);
			status.setComplete();
			List<Cliente> lista=new ArrayList<Cliente>();
			try {
				lista = cliente.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute(lista);
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/error";
		}
		return "redirect:/cliente";
	}
	
	@GetMapping("/{id}/nuevopaciente")
	public String nuevoPaciente(@PathVariable("id") int id, Model model) {
		Alquiler paciente = new Alquiler();
		try {
			Optional<Cliente> medico = cliente.findById(id);
			if(medico.isPresent()) {
				paciente.setCliente(medico.get());
				List<Habitacion> habi = habitacion.findAll();
				model.addAttribute("paciente", paciente);
				model.addAttribute("habitacion", habi);
			} else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/nuevopaciente";
	}
	
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Cliente medico = new Cliente();
		model.addAttribute("medico", medico);
		 inicio(model);
		return "/cliente/nuevo";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> medico = cliente.findById(id);
			if(medico.isPresent()) {
				cliente.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Cliente> medicos = cliente.findAll();
				model.addAttribute("medicos", medicos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/cliente/inicio";
		}
		return "redirect:/cliente";
	}
	
	
	
}
