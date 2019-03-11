package cn.ceac.service;

import java.util.List;

import cn.ceac.pojo.User;

public interface UserService {
	public List<User> find();
	public User get(Integer id);

}
