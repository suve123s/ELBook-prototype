package com.example.demo.Mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.UserList;

@Mapper
public interface UserMapper {

	List<UserList> userlists();

	List<UserList> targetuser(int user_id);

    void create(UserList userList);


	void edit (UserList userList);


	void delete(UserList userList);
}
