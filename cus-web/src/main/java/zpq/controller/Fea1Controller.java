package zpq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fea1")
public class Fea1Controller {
	
	@RequestMapping("gg")
	public Object getObjects() {
		return new Object();
	}
}
