package id.gate.root.gaterootbe.service;


import id.gate.root.gaterootbe.data.dto.request.RequestExperienceDTO;
import org.springframework.http.ResponseEntity;

public interface ExperienceService {

    ResponseEntity findAll();

    ResponseEntity save(RequestExperienceDTO requestExperienceDTO);

    ResponseEntity update(RequestExperienceDTO requestExperienceDTO,Long id);

    ResponseEntity delete(Long id);

    ResponseEntity findById(Long id);
}
