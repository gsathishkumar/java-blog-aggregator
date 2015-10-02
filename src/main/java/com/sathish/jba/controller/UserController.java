package com.sathish.jba.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sathish.jba.entity.Blog;
import com.sathish.jba.entity.User;
import com.sathish.jba.service.BlogService;
import com.sathish.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;

	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}
	
	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/user/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister() {
		return "user-register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:register.html?success=true";
	}
	
	@RequestMapping("/account")
	public String account(Model model,Principal principal) {
		model.addAttribute("user", userService.findOneWithBlogs(principal.getName()));
		return "user-detail";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal) {
		blogService.save(blog,principal.getName());
		return "redirect:account.html";
	}
}
