package nst.springboot.restexample01.controller.repository;

import java.util.Optional;
import nst.springboot.restexample01.controller.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
