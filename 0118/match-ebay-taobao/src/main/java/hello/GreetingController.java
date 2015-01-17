package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "result";
	}
	
	@RequestMapping(value="/greeting", method=RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		model.addAttribute("greeting", greeting);
		System.out.println("id = " + greeting.getId() + "content = " + greeting.getContent());
		return "result";
	}
}

