package com.study.security2.auth;

import com.study.security2.model.Member;
import com.study.security2.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalDetails implements UserDetailsService {

    private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String login_id) throws UsernameNotFoundException {

        Member member = loginRepository.getMember(Member.builder()
                .login_id(login_id)
                .build());

        log.info("member = {}", member);

        if(member != null){
            return member;
        }

        return null;
    }
}
