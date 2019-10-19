package id.gate.root.gaterootbe.dao;


import id.gate.root.gaterootbe.data.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceDAO extends JpaRepository<Experience,Long> {

    @Query("select u from Experience u where u.status = 1 and id = ?1")
    Experience get(Long id);

    @Query("select u from Experience u where u.status = 1")
    List<Experience> select();
}
