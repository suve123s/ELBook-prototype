package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.BookList;

@Mapper	
public interface BookMapper {
                  //本の全情報一覧
    List<BookList> bookfile();
                  //特定の書籍を検索
    List<BookList> searchbook(int book_id);
         //新書籍登録
    void book_entry (BookList booKList);
         //書籍情報の編集
    void book_edit (BookList bookList);
         //書籍情報の削除
    void book_delete(BookList bookList);
	

}
