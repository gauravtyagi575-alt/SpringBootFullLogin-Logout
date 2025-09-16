package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.User;
import com.app.service.UserService;
import com.app.util.RandomPasswordUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEnc;
	
	@GetMapping("/")
	public String root() {
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String doRegister(@ModelAttribute User user, Model model){
		if(userService.findByEmail(user.getEmail())!=null) {
			model.addAttribute("error","Email already Register");
			return "register";
		}
		user.setPassword(passwordEnc.encode(user.getPassword()));
		userService.saveUser(user);
		model.addAttribute("msg","Regester success . !Please Login.");
		return "login";
		
	  }
	
	@PostMapping("/login")
	public String doLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		User user = userService.findByEmail(email);
		if(user!=null && passwordEnc.matches(password, user.getPassword())) {
		session.setAttribute("user", user);
		return "home";
	}
		model.addAttribute("error","Invalid Email or Password");
		return "login";
	}
	
	@GetMapping("/home")
	public String home(HttpSession session) {
		if(session.getAttribute("user") == null) return "redirect:/login";
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/forgot")
	public String forgetPage() {
		return "forgot";
	}
	@PostMapping("/forgot")
	public String doForgot(@RequestParam String email,Model model) {
		User user = userService.findByEmail(email);
		if(user == null) {
			model.addAttribute("error","No user Register with this Email ");
			return "forgot";
		}
		
		String temp = RandomPasswordUtil.generate(10);
		String encoded = passwordEnc.encode(temp);
		userService.updatePassword(user.getId(), encoded);
		model.addAttribute("msg","Temperary password : "+ temp +" please login and change ");
		return "login";
	}
	
	// Change password (only when you logged-in)
	@GetMapping("/change-password")
	public String changePsswordPage(HttpSession session) {
		if(session.getAttribute("user")==null)
			return "redirect:/login";
		return "change-password";
	}
	@PostMapping("/change-password")
	public String doChangePassword(@RequestParam String currentPassword, @RequestParam String newPassword,HttpSession session,Model model) {
		User password = (User)session.getAttribute("user");
		if(password ==null)
			return "redirect:/login";
		
		if(!passwordEnc.matches(currentPassword, password.getPassword())) {
			model.addAttribute("error","Current Password is Incorrect");
			return "change-password";
		}
		userService.updatePassword(password.getId(), passwordEnc.encode(newPassword));
		password.setPassword(passwordEnc.encode(newPassword));
		session.setAttribute("user", password);
		
		model.addAttribute("msg","Password Change Successfully");
		return "home";
	}
  }
	
	

