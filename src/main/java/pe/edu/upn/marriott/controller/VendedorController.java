package pe.edu.upn.marriott.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

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
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/vendedor")
@SessionAttributes( {"vendedor", "habitacion" } )
public class VendedorController { 

	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			model.addAttribute("vendedores", vendedores);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/medico/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if (optional.isPresent()) {
				
				List<Habitacion> habitaciones
					= habitacionService.findAll(); 
				
				model.addAttribute("vendedor", optional.get());
				model.addAttribute("habitaciones", habitaciones);
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) { 
			// TODO: handle exception
		}
		
		return "/vendedor/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("vendedor") Vendedor vendedor, 
			Model model, SessionStatus status) {
		try {
			vendedorService.save(vendedor);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/vendedor";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Vendedor vendedor = new Vendedor();
		model.addAttribute("vendedor", vendedor);
		try {
			List<Habitacion> habitaciones = 
					habitacionService.findAll();
			model.addAttribute("habitaciones", habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if(vendedor.isPresent()) {
				vendedorService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Vendedor> vendedores = vendedorService.findAll();
				model.addAttribute("vendedor", vendedores);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/vendedor/inicio";
		}
		return "redirect:/vendedor";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if(vendedor.isPresent()) {
				model.addAttribute("vendedor", vendedor.get());
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {

		}	
		
		return "/vendedor/info";
	}
	
	@GetMapping("/{id}/nuevahabitacion")
	public String nuevoPaciente(@PathVariable("id") int id, Model model) {
		Habitacion habitacion = new Habitacion();
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if(vendedor.isPresent()) {
				habitacion.setVendedor(vendedor.get());
				model.addAttribute("habitacion", habitacion);
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/nuevahabitacion";
	}
	
	@PostMapping("/savehabitacion")
	public String saveHabitacion(@ModelAttribute("habitacion") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionService.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/vendedor/info/" + habitacion.getVendedor().getId();
	}
	
} 























