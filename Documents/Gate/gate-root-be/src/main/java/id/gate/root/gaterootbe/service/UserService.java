package id.gate.root.gaterootbe.service;

import id.gate.root.gaterootbe.data.dto.request.RequestUserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity findAll();

    ResponseEntity save(RequestUserDTO requestUserDTO);

    ResponseEntity update(RequestUserDTO requestUserDTO,Long id);

    ResponseEntity delete(Long id);

    ResponseEntity findById(Long id);

    ResponseEntity findByUsername(String username);
}
