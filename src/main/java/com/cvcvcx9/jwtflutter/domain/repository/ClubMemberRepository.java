package com.cvcvcx9.jwtflutter.domain.repository;

import com.cvcvcx9.jwtflutter.domain.entity.ClubMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClubMemberRepository extends JpaRepository<ClubMember,Long> {
    //JPA에서는 어떤 컬럼이 다른 테이블의 값을 불러올 때 기본적으로 Lazy로 설정하여 Join하는 것을 막는다.
    //하지만, 다른 테이블의 값이 필요할 때, Lazy로 설정되어있는 경우, 아무런 설정을 해주지 않으면 에러가 발생한다.
    //EntityGraph는 Lazy인 값을 이 쿼리에 한정해서, EAGER로딩이 가능하다.
    @EntityGraph(attributePaths = {"roleSet"},type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from ClubMember m where m.fromSocial = :social and m.email = :email")
    Optional<ClubMember> findByEmail(String email, boolean social);

}
