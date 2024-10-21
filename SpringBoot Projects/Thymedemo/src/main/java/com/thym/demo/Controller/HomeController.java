package com.thym.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("name", "SitaRam");
		model.addAttribute("currdate",new Date().toLocaleString());
		return "about";
	}
	@GetMapping("loopdemo")
	public String loopdemo(Model model) {
		List<String>names=List.of("Ankit","Laxmi","Karan","John");
		model.addAttribute("list",names);
		return "itrdemo";
	}
	@GetMapping("/condition")
	public String cond(Model model) {
		model.addAttribute("isActive",true);
		model.addAttribute("gender","female");
		return "condition";
	}
	@GetMapping("/includeDemo")
	public String incdemo(Model model) {
		model.addAttribute("title", "SitaRam");
		model.addAttribute("subtitle","Jai Bajrang Bali");
		return "includedemo";
	}
	
	@GetMapping("/newabout")
	public String newAbout() {
		return "newabout";
	}
}

