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
		userMapper.create(userList);
		System.out.println("[ " + userList + " ]について登録処理しています");
	}

	public void edit(UserList userList) {
		userMapper.edit(userList);
		System.out.println("[ " + userList + " ]について編集処理をしています");
	}

	public void delete(UserList userList) {
		userMapper.delete(userList);
		System.out.println("[ " + userList + " ]について削除処理しています");
	}

	public List<UserList>lists(){
		System.out.println("全ユーザー情報を取得します");
		return userMapper.userlists();
	}


	public List<UserList> targetuser(int user_id){
		System.out.println("[ " + user_id + " ]の情報を取得しました");
		return userMapper.targetuser(user_id);
	}



}
