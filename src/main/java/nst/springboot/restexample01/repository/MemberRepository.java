package nst.springboot.restexample01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
