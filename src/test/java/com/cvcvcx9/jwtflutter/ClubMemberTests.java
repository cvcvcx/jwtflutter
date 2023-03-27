package com.cvcvcx9.jwtflutter;

import com.cvcvcx9.jwtflutter.domain.entity.ClubMember;
import com.cvcvcx9.jwtflutter.domain.entity.ClubMemberRole;
import com.cvcvcx9.jwtflutter.domain.repository.ClubMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ClubMemberTests {

    @Autowired
    private ClubMemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 100)
                 .forEach(i -> {
                     ClubMember clubMember = ClubMember.builder()
                                                       .name("username" + i)
                                                       .password(passwordEncoder.encode("1111"))
                                                       .email("email" + i + "@gmail.com")
                                                       .build();
                     clubMember.addMemberRole(ClubMemberRole.USER);
                     if(i>80){
                         clubMember.addMemberRole(ClubMemberRole.MANAGER);
                     }
                     if(i>90){
                         clubMember.addMemberRole(ClubMemberRole.ADMIN);
                     }
                     repository.save(clubMember);
                 });
    }

    @Test
    public void testRead(){
        Optional<ClubMember> result = repository.findByEmail("email22@gmail.com",false);
        ClubMember clubMember = result.get();
        System.out.println(clubMember);
    }

}
