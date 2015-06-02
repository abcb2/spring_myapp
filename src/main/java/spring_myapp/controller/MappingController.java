package spring_myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
	@RequestMapping("/path")
	public @ResponseBody String byPath(){
		return "mapped by path!";
	}
	
	@RequestMapping(value="/path/*", method=RequestMethod.GET)
	public @ResponseBody String byPathPattern(HttpServletRequest request){
		return "Mapped by path pattern(" + request.getRequestURI() + ")";
	}
	
	@RequestMapping(value="/header", method=RequestMethod.GET, headers="FooHeader=foo")
	public @ResponseBody String byHeader(){
		return "Mapped by path + method + presence of header";
	}
	@RequestMapping(value="/noheader", method=RequestMethod.GET, headers="!FooHeader")
	public @ResponseBody String byHeaderNegation(){
		return "Mapped by path + method + absence of header";
	}
	
	/*
	 * USE:
	 *   curl -v -D - -H "Content-Type: application/json" -d '{ "foo":"FOO", "fruit":"FRUIT"}' http://localhost:8080/spring_myapp-0.0.1-SNAPSHOT/mapping/consumes
	 */
	@RequestMapping(value="/consumes", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody String byConsumes(@RequestBody MyBean mybean){
//		String mybean = "need json";
		return "Mapped by path + method + consumable media type (javaBean '" + mybean + "')";
	}
	
}
