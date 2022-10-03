package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserList;
import com.example.demo.Mapper.UserMapper;

import lombok.Data;

@Data
@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	
	public void create(UserList userList) {
		System.out.println(userList);
		userMapper.create(userList);
	}
	
	public List<UserList>lists(){
		System.out.println("Mapperまで処理しています");
		return userMapper.userlists();
	}

	public void edit(UserList userList) {
		userMapper.edit(userList);
	}

	public void delete(UserList userList) {
		userMapper.delete(userList);
		System.out.println(" 削除処理しています");
	}
	
	public List<UserList> targetuser(int user_id){
		return userMapper.targetuser(user_id);
	}
}
