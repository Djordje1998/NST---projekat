package nst.springboot.restexample01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.domain.EducationTitle;

public interface EducationTitleRepository extends JpaRepository<EducationTitle, Long> {
    Optional<EducationTitle> findByName(String name);
}
