package com.study.security2.auth;

import com.study.security2.model.Member;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@ToString
public class MemberUserDetails implements UserDetails {

    private Member member;

    //일반 로그인
    public MemberUserDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUser_nm();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //계정이 만료되었는지, false -> 계정 만료
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //계정이 잠겼는지 false -> 계정 잠김
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;//비밀번호가 만료되었는지 false -> 만료
    }

    @Override
    public boolean isEnabled() {
        return true; //계정이 활성화 됐는지 , false -> 계정 비활성화
    }
}
