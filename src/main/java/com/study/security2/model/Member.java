package com.study.security2.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@ToString
@Builder
public class Member implements UserDetails {

    private String login_id;
    private String password;
    private String user_nm;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.user_nm;
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
