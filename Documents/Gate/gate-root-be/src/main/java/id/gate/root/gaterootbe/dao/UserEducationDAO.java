package id.gate.root.gaterootbe.dao;

import id.gate.root.gaterootbe.data.model.UserEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEducationDAO extends JpaRepository<UserEducation,Long> {
    List<UserEducation> findByUserId(Long userId);
}
