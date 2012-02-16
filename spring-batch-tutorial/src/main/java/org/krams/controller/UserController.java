package org.krams.controller;

import java.util.ArrayList;
import java.util.List;

import org.krams.domain.User;
import org.krams.dto.UserDto;
import org.krams.dto.UserListDto;
import org.krams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping
	public String getUsersPage() {
		return "users";
	}
	
	@RequestMapping(value="/records")
	public @ResponseBody UserListDto getUsers() {
		
		UserListDto userListDto = new UserListDto();
		userListDto.setUsers(map(repository.findAll()));
		return userListDto;
	}
	
	private List<UserDto> map(List<User> users) {
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (User u: users) {
			UserDto dto = new UserDto(u.getUsername(), u.getPassword(), u.getFirstName(),
					u.getLastName(), u.getRole().getRole());
			dtos.add(dto);
		}
		return dtos;
	}
}
