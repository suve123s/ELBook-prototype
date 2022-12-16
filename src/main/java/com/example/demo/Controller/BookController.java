package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println("書籍の一覧に遷移しました");
		return "bookinfo";
	}
	
	@GetMapping("/bookedit/{book_id}")
	public String movebookedit(@PathVariable int book_id,Model model) {
		model.addAttribute("BookEdit",bookService.searchbook(book_id));
		System.out.println("BookID[ "+ book_id +" ]の編集画面に遷移しました");
		return "bookedit";
	}
	
	@PostMapping("/bookedit")
	public String bookEdit(@ModelAttribute BookList bookList) {
		bookService.book_edit(bookList);
		System.out.println("書籍の編集処理が完了しました");
		return "bookinfo";
	}
	
    @GetMapping("/book_entry")
    public String movebookEntry() {
    	System.out.println("新書籍の登録画面に遷移しました");
    	return "book_entry";
    }
	
    @PostMapping("/book_entry")
    public String bookEntry(@ModelAttribute BookList bookList) {
    	bookService.book_entry(bookList);
    	System.out.println("新書籍登録処理が完了しました");
    	return "bookinfo";
    }
	
    @PostMapping("/book_delete")
    public String bookDelete(@ModelAttribute BookList bookList) {
    	bookService.book_dlt(bookList);
    	System.out.println("書籍情報の削除処理が完了しました");
    	return "bookinfo";
    }
	
	
}

























