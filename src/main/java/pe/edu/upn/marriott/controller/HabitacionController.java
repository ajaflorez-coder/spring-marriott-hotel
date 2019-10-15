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

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerServices;
import pe.edu.upn.marriott.services.ClienteServices;
import pe.edu.upn.marriott.services.HabitacionServices;
import pe.edu.upn.marriott.services.TipoServices;
import pe.edu.upn.marriott.services.VendedorServices;

@Controller
@RequestMapping("/habitaciones")
@SessionAttributes({"habitaciones","alquiler"})
public class HabitacionController {
	
	
	@Autowired
	private HabitacionServices habitacionServices;

	@Autowired
	private AlquilerServices alquilerServices;
	
	@Autowired
	private TipoServices tipoServices;
	@Autowired
	private ClienteServices clienteServices;
	
	@Autowired
	private VendedorServices vendedorServices;
	
	
	
	@GetMapping
	public String inicio (Model model) {
	
	try {
		List<Habitacion> habitaciones = habitacionServices.findAll();
		model.addAttribute("habitaciones", habitaciones);//habitaciones rojo, es el objeto que se crea y le azul es el nombre con el que se envía al html
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "/habitaciones/listado";
	
	}
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			
			Optional<Habitacion> optional = habitacionServices.findById(id);
		
			
			if (optional.isPresent()) {
				
				List<Tipo> tipos 
					= tipoServices.findAll();
				
				model.addAttribute("habitaciones", optional.get());
				model.addAttribute("tipos", tipos);
			} else {
				return "redirect:/habitaciones";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/habitaciones/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("habitaciones") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionServices.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
		return "redirect:/habitaciones";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion = new Habitacion();
		
		model.addAttribute("habitaciones", habitacion);
		
		try {
			List<Tipo> tipos = tipoServices.findAll();
			model.addAttribute("tipos", tipos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/nuevo";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitaciones = habitacionServices.findById(id);
			if(habitaciones.isPresent()) {
				habitacionServices.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("dangerDel", "ERROR - Violacion contra el principio de Integridad Referencial");
			try {
				List<Habitacion> habitacion= habitacionServices.findAll();
				model.addAttribute("habitaciones", habitacion);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "/habitaciones/listado";
		}
		
		return "redirect:/habitaciones";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitaciones= habitacionServices.findById(id);
			
			if(habitaciones.isPresent()) {
				model.addAttribute("habitaciones", habitaciones.get());
			}else {
				return "redirect:/habitaciones";
			}
		} catch (Exception e) {
			
		}
		return "/habitaciones/info";
	}
	
	
	@GetMapping("/nuevocliente")
	public String nuevocliente(Model model) {
		Cliente cliente = new Cliente();
		
		model.addAttribute("clientes", cliente);
		
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/nuevocliente";
	}
	
	@GetMapping("/{id}/nuevoalquiler")
	public String nuevoAlquiler(@PathVariable("id") int id, Model model) {
		Alquiler alquiler = new Alquiler();
		
		try {
			Optional<Habitacion> habitacion= habitacionServices.findById(id);
			
			List<Cliente> clientes = clienteServices.findAll();
			model.addAttribute("clientes", clientes);
			
			List<Vendedor> vendedores= vendedorServices.findAll();
			model.addAttribute("vendedores", vendedores);

			if(habitacion.isPresent()) {
				
				alquiler.setHabitaciones(habitacion.get());
				model.addAttribute("alquileres", alquiler);
			}else {
				return "redirect:/habitaciones";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/nuevoalquiler";
	}
	
	@PostMapping("/savealquiler")
	public String saveAlquiler(@ModelAttribute("alquileres") Alquiler alquiler,Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			alquilerServices.save(alquiler);
			status.setComplete();
			
			
		} catch (Exception e) {
			
			System.out.println("Ocurrio un error");
		
		}
		return "redirect:/habitaciones/info/"+alquiler.getHabitaciones().getId() ;
	}
	
	
}
