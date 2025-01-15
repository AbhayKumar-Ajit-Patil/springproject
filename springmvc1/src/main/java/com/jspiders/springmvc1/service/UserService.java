package com.jspiders.springmvc1.service;

import java.util.List;


import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc1.dao.UserDAO;

import com.jspiders.springmvc1.dto.UserDTO;

@Component
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public boolean addUser(String name, String email, long mobile, String password) {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setEmail(email);
		userDTO.setMobile(mobile);
		userDTO.setPassword(password);
		try {
			userDAO.addUser(userDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UserDTO authUser(String email, String password) {
		try {
			UserDTO user = userDAO.authUser(email, password);
			if (user.getEmail().equals(email) && user.getPassword().equals(password))
				return user;
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public List<UserDTO> findAllUsers() {
		List<UserDTO> users = userDAO.findAllUser();
		if(users.size()> 0)

		return users;
		else
			return null;
	}
	public boolean deleteuserbyId(int id) {
		try {
			userDAO.deleteuserbyId(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public UserDTO findUserById(int id) {
		return userDAO.findUserById(id);
	}

	public boolean updateUser(int id, String name, String email, long mobile, String password) {
		try {
			userDAO.updateUser(id, name, email, mobile,password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	}

	

