package nst.springboot.restexample01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.domain.AcademicTitle;

public interface AcademicTitleRepository extends JpaRepository<AcademicTitle, Long> {
    Optional<AcademicTitle> findByName(String name);
}
