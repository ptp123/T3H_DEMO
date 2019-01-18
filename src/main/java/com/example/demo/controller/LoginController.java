package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public String login(ModelMap map) {
 	map.addAttribute("user", new User());
	return "login";
    }
    
    @RequestMapping(value = { "/", "/login.do" }, method = RequestMethod.POST)
    public String checkLogin(ModelMap map, User user, HttpServletRequest request) {
	
	String email = user.getEmail();
	String pass = user.getPassword();
	boolean check = checkLogin(email, pass);
	if(check) {
	    map.addAttribute("user", new User(email, pass));
	    return "personal/listPersonal";
	}
	return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
	ModelAndView modelAndView = new ModelAndView();
	User user = new User();
	modelAndView.addObject("user", user);
	modelAndView.setViewName("registration");
	return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	ModelAndView modelAndView = new ModelAndView();
	User userExists = userService.findUserByEmail(user.getEmail());
	if (userExists != null) {
	    bindingResult.rejectValue("email", "error.user",
		    "There is already a user registered with the email provided");
	}

	if (bindingResult.hasErrors()) {
	    modelAndView.setViewName("registration");
	} else {
	    userService.saveUser(user);
	    modelAndView.addObject("successMessage", "User has been registered successfully");
	    modelAndView.addObject("user", new User());
	    modelAndView.setViewName("registration");
	}
	return modelAndView;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
	ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName", "Welcome " + " (" + user.getEmail() + ")");
	modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
	modelAndView.setViewName("admin/home");
	return modelAndView;
    }
    
    private boolean checkLogin(String email, String password) {
	if(email.equals("email") && email.equals("password")) {
	    return true;
	} else return false;
    }
}