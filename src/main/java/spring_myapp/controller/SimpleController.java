package spring_myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	@RequestMapping("/simple")
	public @ResponseBody String simple(){
		return "Hello World";
	}
	
	@RequestMapping(value="/simple/revisited", method=RequestMethod.GET, headers="Accept=text/plain")
	public @ResponseBody String simple2(){
		return "Hello World Revisited!!";
	}
}
