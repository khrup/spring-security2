package com.study.security2.controller;

import com.study.security2.model.Member;
import com.study.security2.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login/Login";
    }

    @GetMapping("/member")
    public String member(Model model){
        return "mypage/Member";
    }

    @GetMapping("/memberJoinForm")
    public String memberJoinForm(){
        return "login/MemberJoinForm";
    }

    @GetMapping("/memberList")
    public String memberList(Model model){
        List<Member> allMemberList = loginService.findAllMember();
        model.addAttribute("allMemberList", allMemberList);
        return "mypage/MemberList";
    }

    @PostMapping("/member")
    public String createMember(@ModelAttribute Member member){
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        int successCnt = loginService.createMember(member);
        if(successCnt > 0) {
            return "login/Login";
        }else{
            return "login/MemberJoinForm";
        }
    }
}

