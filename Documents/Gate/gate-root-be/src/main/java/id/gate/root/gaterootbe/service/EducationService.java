package id.gate.root.gaterootbe.service;

import id.gate.root.gaterootbe.data.dto.request.RequestEducationDTO;
import org.springframework.http.ResponseEntity;

public interface EducationService {

    ResponseEntity findAll();

    ResponseEntity save(RequestEducationDTO requestEducationDTO);

    ResponseEntity update(RequestEducationDTO requestEducationDTO,Long id);

    ResponseEntity delete(Long id);

    ResponseEntity findById(Long id);
}
