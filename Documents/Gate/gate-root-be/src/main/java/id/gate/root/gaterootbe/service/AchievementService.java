package id.gate.root.gaterootbe.service;

import id.gate.root.gaterootbe.data.dto.request.RequestAchievementDTO;
import org.springframework.http.ResponseEntity;

public interface AchievementService {

    ResponseEntity findAll();

    ResponseEntity save(RequestAchievementDTO requestAchievementDTO);

    ResponseEntity update(RequestAchievementDTO requestAchievementDTO,Long id);

    ResponseEntity delete(Long id);

    ResponseEntity findById(Long id);

}
