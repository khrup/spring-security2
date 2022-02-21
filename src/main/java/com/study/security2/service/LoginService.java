package com.study.security2.service;

import com.study.security2.model.Member;
import com.study.security2.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    final private LoginRepository loginRepository;

    public int createMember(Member member){
        log.info("member = {}", member);
        return loginRepository.createMember(member);
    }

    public List<Member> findAllMember(){
        return loginRepository.findAllMember();
    }
}
