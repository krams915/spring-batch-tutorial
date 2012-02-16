package org.krams.dto;

public class UserDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	private Integer role;

	public UserDto() {}
	
	public UserDto(String username, String password, String firstName, String lastName, Integer role) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	public UserDto(String username, String firstName, String lastName, Integer role) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public UserDto(String username) {
		this.username = username;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
