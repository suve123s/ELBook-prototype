package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class BookService {

	@Autowired
	//BookMapper bookMapper;


	public void bookcreate() {
		System.out.println();
		System.out.println("書籍の登録処理をしています");
		//bookMapper.
	}


}
