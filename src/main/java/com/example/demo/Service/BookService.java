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
		System.out.println("新規書籍登録処理をしています");
		//bookMapper.
	}
                  //本一覧の情報を取得
	public List<BookList>bookfile() {
		System.out.println("Bookfileについて処理しています");
		return bookMapper.bookfile();
	}
	
	public List<BookList>searchbook(int book_id){
		System.out.println("[ " + book_id + " ]の情報を取得します。");
		return bookMapper.searchbook(book_id);
	}
	
	public void book_edit(BookList bookList) {
        bookMapper.book_edit(bookList);
        System.out.print("[ " + bookList + " ]の情報を編集処理をしています");
	}
	public void book_entry(BookList bookList) {
		bookMapper.book_entry(bookList);
		System.out.println("[ " + bookList + " ]の情報を登録処理しています");
		
	}

	public void book_dlt(BookList bookList) {
		bookMapper.book_delete(bookList);
		System.out.println("[ " + bookList + " ]の情報を削除処理しています");
	}

}
