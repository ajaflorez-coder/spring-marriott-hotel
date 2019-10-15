package pe.edu.upn.marriott.controller;

import java.security.Provider.Service;
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

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.VendedorService;



@Controller
@RequestMapping("/vendedor")
@SessionAttributes( {"vendedor", "alquiler" ,"habitacion"} )
public class VendedorController {
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private AlquilerService alquilerService;
	@Autowired
	private HabitacionService HabitacionService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			model.addAttribute("vendedores", vendedores);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if (optional.isPresent()) {
				
				
				model.addAttribute("vendedor", optional.get());
			
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/vendedor/edit";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if(vendedor.isPresent()) {
				vendedorService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Vendedor> vendedores = vendedorService.findAll();
				model.addAttribute("vendedores", vendedores);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/vendedor/inicio";
		}
		return "redirect:/vendedor";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Vendedor vendedor = new Vendedor();
		model.addAttribute("vendedor", vendedor);
		
		return "/vendedor/nuevo";
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
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") String id, Model model) {
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
	
	
	@GetMapping("/{id}/nuevoAlquiler")
	public String nuevoAlquiler(@PathVariable("id") String id, Model model) {
		Alquiler alquiler = new Alquiler();
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if(vendedor.isPresent()) {
				alquiler.setVendedor(vendedor.get());
				model.addAttribute("alquiler", alquiler);
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/nuevoAlquiler";
	}
	
	@PostMapping("/saveAlquiler")
	public String saveAlquiler(@ModelAttribute("alquiler")Alquiler alquiler, 
			Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/vendedor/info/" + alquiler.getVendedor().getId();
	}
	
	@GetMapping("/{id}/nuevaHabitacion")
	public String nuevaHabitacion(@PathVariable("id") int id, Model model) {
		Habitacion habitacion = new Habitacion();
		try {
			Optional<Alquiler> alquiler = alquilerService.findById(id);
			if(alquiler.isPresent()) {
				List<Alquiler> alquileres=  alquilerService.findAll();
				habitacion.setAlquileres(alquileres);;
				model.addAttribute("alquileres", alquileres);
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/nuevoHabitacion";
	}
	
	@PostMapping("/saveHabitacion")
	public String saveHabitacion(@ModelAttribute("habitacion")Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			HabitacionService.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/vendedor/info/" + habitacion.getId();
	}
	
	
}