package id.gate.root.gaterootbe.service;


import id.gate.root.gaterootbe.data.dto.request.RequestProfilePhotoDTO;
import org.springframework.http.ResponseEntity;

public interface ProfilePhotoService {

    ResponseEntity findAll();

    ResponseEntity save(RequestProfilePhotoDTO requestProfilePhotoDTO);

    ResponseEntity update(RequestProfilePhotoDTO requestProfilePhotoDTO,Long id);

    ResponseEntity delete(Long id);

    ResponseEntity findById(Long id);

    ResponseEntity findByUserIdApply(Long userId);

}
