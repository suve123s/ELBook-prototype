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
		System.out.println("登録処理しています。登録処理２");
		userMapper.create(userList);
	}

	public void edit(UserList userList) {
		System.out.println(userList);
		userMapper.edit(userList);
		System.out.println("編集処理をしています。編集処理２");
	}

	public void delete(UserList userList) {
		userMapper.delete(userList);
		System.out.println(userList);
		System.out.println("削除処理しています");
	}

	public List<UserList>lists(){
		System.out.println("UserListについて処理しています");
		return userMapper.userlists();
	}





	public List<UserList> targetuser(int user_id){
		return userMapper.targetuser(user_id);
	}



}
