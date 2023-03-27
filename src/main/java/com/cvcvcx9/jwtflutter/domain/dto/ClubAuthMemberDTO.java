package com.cvcvcx9.jwtflutter.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Slf4j
@Getter
@Setter
@ToString
public class ClubAuthMemberDTO extends User {

    private String name;
    private String email;
    private boolean fromSocial;

    public ClubAuthMemberDTO(String username, String password,boolean fromSocial, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
    }
}
