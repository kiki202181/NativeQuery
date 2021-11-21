package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

//import com.example.demo.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NativeQueryController {

	@Autowired
	UserRepository userRepository;
	List<User> UserList;

	@GetMapping("/")
	public String view(Model model) {
		// 全取得
		UserList = userRepository.findAllUser();
		model.addAttribute("UserList", UserList);

		return "View";
	}

	@PostMapping("/add")
	public String add(Model model) {
		model.addAttribute("User", new User());
		return "Edit";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id", required = false) Long id) {

		int result = userRepository.deleteUser(id);
		System.out.println(result);
		return "redirect:/";
	}

	@PostMapping("/edit/{id}")
	public String edit(@PathVariable(value = "id", required = false) Long id, Model model) {
		User user = new User();
		user = userRepository.getById(id);
		model.addAttribute("User", user);
		return "Edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute User user, Model model) {

		System.out.println(user.getId());
//		userRepository.addUser(name);
		UserList = userRepository.findAllUser();
		model.addAttribute("UserList", UserList);
		return "View";
	}

	@PostMapping("/search")
	public String edit(@RequestParam(value = "name", required = false, defaultValue = "%") String name, Model model) {
		System.out.println(name);
		UserList = userRepository.searchUser(name);
		model.addAttribute("UserList", UserList);
		return "View";
	}

}
