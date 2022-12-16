package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BookList;
import com.example.demo.Mapper.BookMapper;

import lombok.Data;

@Data
@Service
public class BookService {

	@Autowired
	BookMapper bookMapper;

               //新規の書籍情報を登録
	public void book_entry() {
		System.out.println();
		System.out.println("書籍の登録処理をしています");
		//bookMapper.
	}
                  //本一覧の情報を取得
	public List<BookList>bookfile() {
		System.out.println("Bookfileについて処理しています");
		return bookMapper.bookfile();
	}
	
	public void book_edit(BookList bookList) {
        System.out.println(bookList);
        bookMapper.book_edit(bookList);
        System.out.print("編集処理をしています");
	}


}
