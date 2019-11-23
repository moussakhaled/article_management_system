package tn.moussa.springbootangular.ams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
	
	@GetMapping("/home")
	//@ResponseBody	
	public String home(@RequestParam(required = false, defaultValue = "Spring Boot") String framework, ModelMap monObj) {
			monObj.put("myframework", framework);
			return "pages/home"; //<h1 align = center>Spring boot MVC Layer</h1>";
	}

}
