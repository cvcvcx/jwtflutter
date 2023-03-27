package com.cvcvcx9.jwtflutter.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClubMember extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String password;

    private boolean fromSocial;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ClubMemberRole> roleSet = new HashSet<>();
    public void addMemberRole(ClubMemberRole clubMemberRole){
        roleSet.add(clubMemberRole);
    }


}


