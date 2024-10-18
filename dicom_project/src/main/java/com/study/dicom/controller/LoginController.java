package com.study.dicom.controller;

import com.study.dicom.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 로그인 페이지 표시
	
	  @GetMapping("/")
	  public String loginForm() {
		  return "login/login";
		  }
	 
	  @GetMapping("/list")
	  public String index() {
	      return "index"; // index.html 파일을 반환
	  }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("userPassword") String userPassword,
                        Model model) {
        // 로그인 서비스에서 사용자 인증 처리
        boolean isLoginSuccessful = loginService.login(userName, userPassword);
        
        if (isLoginSuccessful) {
            // 로그인 성공 시 header.html 페이지로 리디렉션
            return "redirect:/list"; // 로그인 성공 후 헤더 페이지로 이동
        } else {
            // 로그인 실패 시 다시 로그인 페이지로 돌아가고 에러 메시지 출력
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/"; // 로그인 실패 시 다시 로그인 페이지로
        }
    }
}
