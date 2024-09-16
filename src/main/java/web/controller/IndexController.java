package web.controller;

import application.dao.UserDao;
import application.model.User;
import application.service.UserService;
import application.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {


	private UserService userService;


//    public IndexController(UserService userService) {
//        this.userService = userService;
//    }


    @GetMapping(value = "/")
	public String showAllUsers(Model model) {
	List<User> allUsers = userService.getAllUsers();
	model.addAttribute("users", allUsers);
		return "index";
	}
	
}