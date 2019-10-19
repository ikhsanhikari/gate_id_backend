package id.gate.root.gaterootbe.dao;

import id.gate.root.gaterootbe.data.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationDAO extends JpaRepository<Education,Long> {

    @Query("select u from Education u where u.status = 1 and id = ?1")
    Education get(Long id);

    @Query("select u from Education u where u.status = 1")
    List<Education> select();

}
