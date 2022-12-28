package com.example.demo.Entity;



import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Validated
public class UserList {


	private int user_id;
	
	@NotBlank
	@UniqueUsername
	private String user_name;
	
	@NotBlank
	@Size(min = 4 ,max=4)
	private String pass;
	
	private int operator;
	


	public int getUser_id() {
		return user_id;
	}public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}
}
