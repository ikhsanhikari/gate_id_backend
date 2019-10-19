package id.gate.root.gaterootbe.dao;

import id.gate.root.gaterootbe.data.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AchievementDAO extends JpaRepository<Achievement,Long> {

    @Query("select u from Achievement u where u.status = 1 and id = ?1")
    Achievement get(Long id);

    @Query("select u from Achievement u where u.status = 1")
    List<Achievement> select();

    @Query("select u from Achievement u where u.status = 1 and u.id = ?1")
    List<Achievement> selectByUser(Long achievementId);

}
