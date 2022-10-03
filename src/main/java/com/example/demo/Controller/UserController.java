package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.UserList;
import com.example.demo.Service.UserService;

// コントローラを作る時必ず定義すること
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	

//	http://localhost:8043/loginの場合遷移
//	@GetMapping("/login") 
		
//	public String login()は任意
//		return "login";遷移したHTMLを指定
//	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/home")
	public String home() {
		System.out.println("home画面に遷移しています。");
		return "home";
	}
	
	@GetMapping("/useredit")
	public String findUser(Model model) {
		model.addAttribute("UserList", userService.lists());
		return "useredit";
	}
	
	@GetMapping("/delete/{user_id}")
 	public String userEdit(@PathVariable int user_id,Model model) {
		 model.addAttribute("TargetUser", userService.targetuser(user_id));
		 System.out.println("user_idを渡す");
		 return "useredit";
     }
	//GetMappingで遷移
	//return 〇〇 で　〇〇が帰ってくる
	@GetMapping("/usercreate")
	public String moveusercreate() {
		System.out.println("新規画面に遷移してます");
		return "usercreate";
	}
	
	
	@PostMapping("/usercreate")
	public String userCreate (@ModelAttribute UserList userList) {
		userService.create(userList);
		System.out.println("登録OK");
		return "login";
	}
	
	
	@PostMapping("/useredit")
	 public String userEdit(@ModelAttribute ("editUser") UserList userList) {
	       System.out.println("編集画面に遷移");
	       userService.edit(userList);
	       return "useredit";
	}
	
	@PostMapping("/delete")
	public String userDelete(@ModelAttribute("deleteUser") UserList userList) {
		System.out.println("削除しました。");
		//userService.delete(userList);
		return "useredit";
	}
	
	
	
}

