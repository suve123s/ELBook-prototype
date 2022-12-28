package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.UserList;
import com.example.demo.Service.BookService;
import com.example.demo.Service.UserService;

import lombok.RequiredArgsConstructor;

// コントローラを作る時必ず定義すること
@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	UserService userService;
	BookService bookService;
	


//	http://localhost:8043/loginの場合遷移
//	@GetMapping("/login")

//	public String login()は任意
//		return "login";遷移したHTMLを指定

    //認証画面表示処理
	@GetMapping
	public String home() {
		System.out.println("ログインに成功しました");
		return "home";
	}
	
     // home画面への遷移
	@GetMapping("/login")
	public String login() {
		System.out.println("認証画面を表示しました");
		return "login";
	}
	
	//ログアウト
	@GetMapping("/logout")
	public String logout() {
		System.out.print("ログアウトしました");
		return "login";
	}
     
	//  ユーザーの一覧表示処理
	@GetMapping("/userinfo")
	public String findUser(Model model) {
		model.addAttribute("UserFolder", userService.lists());
		System.out.println("ユーザー一覧を表示");
		return "userinfo";
	}


	//   ユーザー情報の編集処理
	@GetMapping("/useredit/{user_id}")
	public String moveEdit(@PathVariable int user_id,Model model) {
		model.addAttribute("Edituser", userService.targetuser(user_id));
        System.out.println("ユーザーID["+ user_id +"]を/usereditに渡して編集に移行します");
		return "useredit";
	}


    //新規ユーザー情報の登録
	//GetMappingで遷移
	//return 〇〇 で 〇〇が帰ってくる
	@GetMapping("/usercreate")
	public String moveUserCreate() {
		System.out.println("新規登録画面に遷移しました");
		return "usercreate";
	}
	
    //マイページに遷移
	@GetMapping("/mypage")
	public String moveMypage() {
		System.out.println("マイページに遷移しました");
		return "mypage";
	}


             //新規登録機能（ユーザーとパスワードを登録できる）
	@PostMapping("/usercreate")
	public String userCreate (@ModelAttribute UserList userList) {
		userService.create(userList);
		System.out.println("登録処理が完了しました");
		return "login";
	}

	           //th:action〇〇で飛ぶ   //ユーザー情報の編集
	@PostMapping("/useredit")
	public String userEdit(@ModelAttribute  UserList userList) {
		userService.edit(userList);
		System.out.println("編集処理が完了しました");
		return "userinfo";
	}

	//th:action="@{/delete}"で飛んでくる
	@PostMapping("/delete")      //↓th:object="${user_delete}"で飛んでくる
	public String userDelete(@ModelAttribute UserList userList) {
		userService.delete(userList);
		System.out.println("削除処理を完了しました");
		return "home";
	}
	
	 //テスト用
	@GetMapping("/Test")
	public String moveTest(@ModelAttribute UserList useList) {
		System.out.println("テスト");
		return "Test";
	}

}

