package com.safeStops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safeStops.model.User;
import com.safeStops.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users/usersList", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listUsers() {
		return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
	}

}
