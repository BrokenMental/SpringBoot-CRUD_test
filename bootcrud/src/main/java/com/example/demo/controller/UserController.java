package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aspect.TokenRequired;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public UserDTO insertUser(@RequestBody UserDTO user) {
		return userService.insertUser(user);
	}
	
	@GetMapping("")
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsers();
	}
	
	// get Method로 /users/{userId}, header에 token = {token key} 입력
	@TokenRequired
	@GetMapping("/{userId}")
	public UserDTO getUserByUserId(@PathVariable String userId) {
		return userService.getUserByUserId(userId);
	}
	
	@PutMapping("/{userId}")
	public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
		userService.updateUserPw(userId, user);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
	}

}
