package id.gate.root.gaterootbe.service;

import id.gate.root.gaterootbe.data.dto.request.RequestCoverPhotoDTO;
import org.springframework.http.ResponseEntity;

public interface CoverPhotoService {

    ResponseEntity findAll();

    ResponseEntity save(RequestCoverPhotoDTO requestCoverPhotoDTO);

    ResponseEntity update(RequestCoverPhotoDTO requestCoverPhotoDTO,Long id);

    ResponseEntity delete(Long id);

    ResponseEntity findById(Long id);

    ResponseEntity findByUserIdApply(Long userId);

}
