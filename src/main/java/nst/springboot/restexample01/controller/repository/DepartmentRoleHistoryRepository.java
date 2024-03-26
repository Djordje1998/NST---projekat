package nst.springboot.restexample01.controller.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nst.springboot.restexample01.controller.domain.DepartmentRoleHistory;

public interface DepartmentRoleHistoryRepository extends JpaRepository<DepartmentRoleHistory, Long> {

    @Query("SELECT drh FROM DepartmentRoleHistory drh " +
            "WHERE drh.department.id = :departmentId " +
            "AND drh.role = :role " +
            "AND drh.member.id = :memberId " +
            "AND drh.endDate IS NULL")
    Optional<DepartmentRoleHistory> findActiveHistoryByRole(
            @Param("departmentId") Long departmentId, @Param("role") String role, @Param("memberId") Long memberId);

}
