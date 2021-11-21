package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		//全取得
		UserList=userRepository.findAllUser();
		model.addAttribute("UserList",UserList);
		
		
		return "View";
	}
	
	@PostMapping("/search")
	public String edit(Model model) {

		return "Edit";
	}
	
}
