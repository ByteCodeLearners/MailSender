package com.kumar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
	@GetMapping("/")
	public String showEmailPage()
	{
		return "emailPage";
	}
	@PostMapping("/sendEmail")
	public void SubmitEmail(@ModelAttribute String email,@ModelAttribute)
	{
		return "mailStatus";
	}
}
