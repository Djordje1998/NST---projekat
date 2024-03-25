package nst.springboot.restexample01.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.controller.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
