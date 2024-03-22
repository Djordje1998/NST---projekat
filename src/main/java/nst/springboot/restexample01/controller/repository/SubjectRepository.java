package nst.springboot.restexample01.controller.repository;

import nst.springboot.restexample01.controller.domain.Subject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);
}
