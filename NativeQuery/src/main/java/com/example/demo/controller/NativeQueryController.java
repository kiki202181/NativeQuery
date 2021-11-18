package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import com.example.demo.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NativeQueryController {

	
	@GetMapping("/")
	public String view(Model model) {
		//全取得
		return "View";
	}
	
	@PostMapping("/search")
	public String edit(Model model) {

		return "Edit";
	}
	
}
