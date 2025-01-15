
package com.jspiders.springmvc1.controller;

import java.util.List;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc1.dto.UserDTO;
import com.jspiders.springmvc1.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/home")
	protected String getHomePage(HttpSession httpSession) {
		UserDTO authenticatedUser = (UserDTO) httpSession.getAttribute("authenticatedUser");
		if (authenticatedUser != null)
			return "home";
		else
			return "login";
	}

	@RequestMapping(path = "/sign-up-page")
	protected String getSignUpPage() {
		return "sign_up";
	}

	@RequestMapping(path = "/add-user", method = RequestMethod.POST)
	protected String addUser(@RequestParam(name = "username") String name, @RequestParam(name = "email") String email,
			@RequestParam(name = "mobile") long mobile, @RequestParam(name = "password") String password,
			ModelMap modelMap) {
		boolean userAdded = userService.addUser(name, email, mobile, password);
		if (userAdded) {
			modelMap.addAttribute("message", "User added");
			return "login";
		} else {
			modelMap.addAttribute("message", "Something went wrong");
			return "sign_up";
		}
	}

	@RequestMapping(path = "/login-page")
	protected String getLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/auth-user")
	protected String authUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, ModelMap modelMap, HttpSession httpSession) {
		UserDTO authenticatedUser = userService.authUser(email, password);
		if (authenticatedUser != null) {
			httpSession.setAttribute("authenticatedUser", authenticatedUser);
			httpSession.setMaxInactiveInterval(180);
			return "home";
		} else {
			modelMap.addAttribute("message", "Invalid email or password");
			return "login";
		}
	}
	@RequestMapping(path = "/users")
	protected String findAllUsers(ModelMap modelMap) {
		List<UserDTO> contacts = userService.findAllUsers();
		if (contacts != null)
			modelMap.addAttribute("users", contacts);
		else
			modelMap.addAttribute("message", "users not found");
		return "users";
	}
	@RequestMapping(path= "/delete-user")
	protected String deleteuserbyId(@RequestParam(name = "id") int id , ModelMap modelMap) {
		boolean userdeleted = userService.deleteuserbyId(id);
		if (userdeleted) {
			modelMap.addAttribute("message", "user deleted");
			List<UserDTO> user =  userService.findAllUsers();
			if (user != null)
				modelMap.addAttribute("users", user);
			else
			modelMap.addAttribute("message", "user not found");
		} else
			modelMap.addAttribute("message", "Something went wrong");
		return "users";
	}
	@RequestMapping(path ="/edit-user")
		protected String edituser(@RequestParam(name ="id") int id ,ModelMap modelMap) {
		UserDTO user =userService.findUserById(id);
		modelMap.addAttribute("user", user);
		return "edit-user";
			
		}
	@RequestMapping(path = "/update-user", method = RequestMethod.POST)
	protected String updateUser(@RequestParam(name = "id") int id,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, @RequestParam(name = "mobile") long mobile, @RequestParam(name = "password") String password, ModelMap modelMap) {
		boolean userUpdated = userService.updateUser(id, name, email, mobile, password);
		if (userUpdated ) {
			modelMap.addAttribute("message", "User updated");
			List<UserDTO> users = userService.findAllUsers();
			modelMap.addAttribute("users", users);
		} else
			modelMap.addAttribute("message", "Something went wrong");
		return "users";
	}
		
	
	

	@RequestMapping(path = "/logout")
	protected String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}

}
