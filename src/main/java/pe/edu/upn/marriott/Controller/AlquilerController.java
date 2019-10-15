package pe.edu.upn.marriott.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {
	List<Habitacion> habitaciones;
	List<Cliente> clientes;
	List<Vendedor> vendedores;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AlquilerService alquilerService;
	
	@Autowired
	private VendedorService vendedorService;
	
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Alquiler alquiler = new Alquiler();
		model.addAttribute("alquiler",alquiler);
		try {
			habitaciones = habitacionService.findAll();
			clientes = clienteService.findAll();
			vendedores = vendedorService.findAll();
			
			model.addAttribute("habitaciones", habitaciones);
			model.addAttribute("clientes", clientes);
			model.addAttribute("vendedores",vendedores);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "nuevaHab";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("alquiler") Alquiler alquiler, Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "index";
	}
}
