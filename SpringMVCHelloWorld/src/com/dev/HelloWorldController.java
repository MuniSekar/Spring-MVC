package com.dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {

		String message = "Hello World to SpringMVC3 form MUNISEKAR";
		return new ModelAndView("hello", "message", message);
	}
}