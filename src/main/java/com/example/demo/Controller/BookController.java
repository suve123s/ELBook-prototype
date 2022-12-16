package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.BookList;
import com.example.demo.Service.BookService;


@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
  
	//本の一覧の表示処理
	@GetMapping("/bookinfo")
	public String movebooklist(Model model){
		model.addAttribute("BookList",bookService.bookfile());
		System.out.println("本の一覧に遷移しました");
		return "bookinfo";
	}
	
//	@PostMapping("/delete/{book_id}")
//	public String move
 
	@PostMapping("/bookinfo")
	public String userInfo(@ModelAttribute ("editUser") BookList bookList) {
		bookService.book_edit(bookList);
		System.out.println("社員一覧画面に遷移しました");
		return "bookinfo";
	}
}
