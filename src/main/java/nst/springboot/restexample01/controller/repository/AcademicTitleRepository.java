package nst.springboot.restexample01.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nst.springboot.restexample01.controller.domain.AcademicTitle;

public interface AcademicTitleRepository extends JpaRepository<AcademicTitle, Long>{

}
