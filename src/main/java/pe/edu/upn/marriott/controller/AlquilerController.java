package pe.edu.upn.marriott.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.VendedorService;


@Controller
@RequestMapping("/alquiler")
@SessionAttributes( {"alquiler" , "habitacion" , "vendedor" , "cliente"} )
public class AlquilerController {

	
	@Autowired
	private AlquilerService alquilerService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Alquiler> alquileres = alquilerService.findAll();
			model.addAttribute("alquileres", alquileres);//mismo nombre
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Alquiler/inicio";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Alquiler alquiler = new Alquiler();
		model.addAttribute("alquiler", alquiler);
		try {
			List<Habitacion> habitaciones = 
					habitacionService.findAll();
			model.addAttribute("habitaciones", habitaciones);
			
			List<Vendedor> vendedores = 
					vendedorService.findAll();
			model.addAttribute("vendedores", vendedores);
			
			List<Cliente> clientes= 
					clienteService.findAll();
			model.addAttribute("clientes", clientes);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Alquiler/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("alquiler") Alquiler alquiler, 
			Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/alquiler";
	}
	
	//Formato de Fecha
	@InitBinder("alumno")
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
		
		binder.registerCustomEditor(Date.class , "fechaEntrada" , 
									new CustomDateEditor(dateFormatter, true));
		
		binder.registerCustomEditor(Date.class , "fechaSalida" , 
				new CustomDateEditor(dateFormatter, true));
	}
	
}
