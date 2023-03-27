package com.cvcvcx9.jwtflutter.service;

import com.cvcvcx9.jwtflutter.domain.dto.ClubAuthMemberDTO;
import com.cvcvcx9.jwtflutter.domain.entity.ClubMember;
import com.cvcvcx9.jwtflutter.domain.repository.ClubMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubUserDetailService implements UserDetailsService {
    private final ClubMemberRepository clubMemberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("ClubUserDetailService loadUserByUserName {}", username);
        Optional<ClubMember> result = clubMemberRepository.findByEmail(username, false);
        if (!result.isPresent()) {
            throw new UsernameNotFoundException("Check Email or Social");
        }

        ClubMember clubMember = result.get();
        log.info("--------------------------------------------------");
        log.info(clubMember.toString());

        ClubAuthMemberDTO clubAuthMember = new ClubAuthMemberDTO(
                clubMember.getEmail(),
                clubMember.getPassword(),
                clubMember.isFromSocial(),
                clubMember.getRoleSet()
                          .stream()
                          .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                          .collect(Collectors.toSet())
        );
        clubAuthMember.setName(clubMember.getName());
        clubAuthMember.setFromSocial(clubMember.isFromSocial());

        return clubAuthMember;
    }
}
