package com.todoapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class TodoApplication {





	@RequestMapping("/index")
	@ResponseBody
	String home() {
		return "index";
	}

	public static void main(String[] args) throws Exception{
		SpringApplication.run(TodoApplication.class, args);
	}

}
