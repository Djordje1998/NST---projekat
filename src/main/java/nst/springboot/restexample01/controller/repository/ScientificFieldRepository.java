package nst.springboot.restexample01.controller.repository;

import nst.springboot.restexample01.controller.domain.ScientificField;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {
    Optional<ScientificField> findByName(String name);

}
