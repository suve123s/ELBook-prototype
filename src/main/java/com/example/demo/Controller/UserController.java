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

// コントローラを作る時必ず定義すること
@Controller
public class UserController {

	@Autowired
	UserService userService;
	BookService bookService;
	


//	http://localhost:8043/loginの場合遷移
//	@GetMapping("/login")

//	public String login()は任意
//		return "login";遷移したHTMLを指定
//	}

    //認証画面表示処理
	@GetMapping("/login")
	public String login() {
		System.out.println("認証画面を表示");
		return "login";
	}
	
     // home画面への遷移
	@GetMapping("/home")
	public String home() {
		System.out.println("HOME画面に遷移しました");
		return "home";
	}
     
	//  ユーザーの一覧表示処理
	@GetMapping("/userinfo")
	public String findUser(Model model) {
		model.addAttribute("UserFolder", userService.lists());
		System.out.println("ユーザー一覧を表示");
		return "userinfo";
	}
	
//	@GetMapping("/bookinfo")
//	public String movebooklist(Model model){
//		model.addAttribute("BookList",bookService.bookfile());
//		System.out.println("本の一覧に遷移しました");
//		return "bookinfo";
//	}

    //   ユーザー情報の削除処理
	@GetMapping("/delete/{user_id}")
 	public String userEdit(@PathVariable int user_id,Model model) {
		 model.addAttribute("TargetUser", userService.targetuser(user_id));
		 System.out.println("user_idを渡す");
		 return "userinfo";
     }

	//   ユーザー情報の編集処理
	@GetMapping("/useredit/{user_id}")
	public String moveEdit(@PathVariable int user_id) {
		System.out.println(user_id);
        System.out.println("user_idをeditに渡す");
		return "useredit";
	}


    //新規ユーザー情報の登録
	//GetMappingで遷移
	//return 〇〇 で　〇〇が帰ってくる
	@GetMapping("/usercreate")
	public String moveusercreate() {
		System.out.println("新規画面に遷移しました");
		return "usercreate";
	}
    //マイページに遷移
	@GetMapping("/mypage")
	public String moveMypage() {
		System.out.println("マイページに遷移しました");
		return "mypage";
	}

    //編集画面に遷移
	@GetMapping("/useredit")
	public String moveUseredit(@ModelAttribute("user_edit") UserList useList) {
		System.out.println("編集画面に遷移しました");
		return "useredit";
	}

//    @GetMapping("/Test2")
//    public String moveTest2() {
//    	System.out.println("テスト２");
//    	return "Test2";
//    			 
//    }

	 //テスト用
	@GetMapping("/Test")
	public String moveTest(@ModelAttribute UserList useList) {
		System.out.println("テスト");
		return "Test";
	}

             //新規登録機能（ユーザーとパスワードを登録できる）
	@PostMapping("/usercreate")
	public String userCreate (@ModelAttribute UserList userList) {
		System.out.println("登録OKです。登録処理１");
		userService.create(userList);
		System.out.println("登録しました。登録処理3");
		return "login";
	}

	           //th:action〇〇で飛ぶ   //ユーザー情報の編集
	@PostMapping("/useredit")
	public String userEdit(@ModelAttribute  UserList userList) {
		System.out.println("編集処理を行っています。編集処理１");
		userService.edit(userList);
		System.out.println("編集処理を行っています。編集処理３");
		return "userinfo";
	}

	//th:action="@{/delete}"で飛んでくる
	@PostMapping("/delete")      //↓th:object="${user_delete}"で飛んでくる
	public String userDelete(@ModelAttribute("user_delete") UserList userList) {
		userService.delete(userList);
		System.out.println("deleteController");
		System.out.println(userList);
		return "home";
	}

	@PostMapping("/userinfo")            //↓th:object="${editUser}"で飛んでくる
	 public String userInfo(@ModelAttribute ("editUser") UserList userList) {
	       userService.edit(userList);
	       System.out.println("社員一覧画面に遷移しました");
	       return "userinfo";
	}

}

