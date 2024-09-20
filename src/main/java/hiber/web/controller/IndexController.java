package hiber.web.controller;

import hiber.application.config.AppConfig;
import hiber.application.service.UserService;
import hiber.application.service.UserServiceImp;
import hiber.web.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hiber.application.model.User;

@Controller
public class IndexController {

//	AnnotationConfigApplicationContext context =
//			new AnnotationConfigApplicationContext(WebConfig.class);

//	public AnnotationConfigApplicationContext getContext() {
//		return context;
//	}

	private UserService userService;

    @GetMapping(value = "/")
	public String showAllUsers(Model model) {
//	List<User> allUsers = userService.getAllUsers();
//	model.addAttribute("users", allUsers);
		return "index";
	}
	
}