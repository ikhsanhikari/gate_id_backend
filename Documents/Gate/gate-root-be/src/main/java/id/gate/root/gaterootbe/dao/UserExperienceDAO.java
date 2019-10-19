package id.gate.root.gaterootbe.dao;


import id.gate.root.gaterootbe.data.model.UserExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserExperienceDAO extends JpaRepository<UserExperience,Long> {
    List<UserExperience> findByUserId(Long userId);
}
