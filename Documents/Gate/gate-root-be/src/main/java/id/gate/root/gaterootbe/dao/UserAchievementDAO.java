package id.gate.root.gaterootbe.dao;

import id.gate.root.gaterootbe.data.model.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAchievementDAO extends JpaRepository<UserAchievement,Long> {
    List<UserAchievement> findByUserId(Long userId);
}
