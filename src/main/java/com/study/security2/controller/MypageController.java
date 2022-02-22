package com.study.security2.controller;

import com.study.security2.auth.MemberUserDetails;
import com.study.security2.model.Member;
import com.study.security2.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mypage")
public class MypageController {

    private final LoginService loginService;

    @GetMapping("/member")
    public String member(Model model, Authentication authentication) {
        Member member = (Member) authentication.getPrincipal();
        log.info("member = {}", member);
        return "mypage/Member";
    }

    @GetMapping("/memberList")
    public String memberList(Model model) {
        List<Member> allMemberList = loginService.findAllMember();
        model.addAttribute("allMemberList", allMemberList);
        return "mypage/MemberList";
    }

}
