package pe.edu.upn.marriott.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	@GetMapping
	public String index() {
		return "index";	// Archivo html que se devuelve
	}

}
