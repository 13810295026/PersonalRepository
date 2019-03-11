package cn.ceac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ceac.pojo.User;
import cn.ceac.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/find")
	public List<User> find() {
		return userService.find();
	}
	
	@RequestMapping("/get/{id}")
	public User get(@PathVariable Integer id){
		return userService.get(id);
	}
}
