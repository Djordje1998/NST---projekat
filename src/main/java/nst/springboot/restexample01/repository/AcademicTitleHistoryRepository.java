package nst.springboot.restexample01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nst.springboot.restexample01.domain.AcademicTitleHistory;

public interface AcademicTitleHistoryRepository extends JpaRepository<AcademicTitleHistory, Long> {

    @Query("SELECT ath FROM AcademicTitleHistory ath " +
            "WHERE ath.member.id = :memberId " +
            "AND ath.endDate IS NULL")
    Optional<AcademicTitleHistory> findLastHistory(@Param("memberId") Long memberId);

}
