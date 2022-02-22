package com.study.security2.controller;

import com.study.security2.model.Member;
import com.study.security2.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/loginForm")
    public String login() {
        return "login/Login";
    }

    @GetMapping("/memberJoinForm")
    public String memberJoinForm() {
        return "login/MemberJoinForm";
    }

    @PostMapping("/member")
    public String createMember(@ModelAttribute Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        int successCnt = loginService.createMember(member);
        if (successCnt > 0) {
            return "login/Login";
        } else {
            return "login/MemberJoinForm";
        }
    }

    @GetMapping("/session")
    @ResponseBody
    public String session(HttpSession session){
        log.info("session_id = {}", session.getId());
        log.info("getAttributeNames = {}", session.getAttributeNames().toString());
        session.setAttribute("gg", "gg");
        Enumeration<String> attributeNames = session.getAttributeNames();

       Member member = (Member)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       log.info("member = {}", member);
       log.info("session = {}", session.getAttribute("SPRING_SECURITY_CONTEXT"));

        while(attributeNames.hasMoreElements()){
            log.info("attributeName = {}", attributeNames.nextElement());
        }
        return "zzz";
    }
}

