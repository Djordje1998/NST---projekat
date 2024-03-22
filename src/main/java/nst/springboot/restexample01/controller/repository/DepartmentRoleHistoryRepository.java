package nst.springboot.restexample01.controller.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nst.springboot.restexample01.controller.domain.DepartmentRoleHistory;

public interface DepartmentRoleHistoryRepository extends JpaRepository<DepartmentRoleHistory, Long> {

}
