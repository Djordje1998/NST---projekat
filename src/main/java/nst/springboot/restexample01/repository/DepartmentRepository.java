package nst.springboot.restexample01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
