package id.gate.root.gaterootbe.endpoint.impl;

import id.gate.root.gaterootbe.data.dto.request.RequestProfilePhotoDTO;
import id.gate.root.gaterootbe.endpoint.ProfilePhotoEndPoint;
import id.gate.root.gaterootbe.service.ProfilePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilePhotoEndPointImpl implements ProfilePhotoEndPoint {

    @Autowired
    private ProfilePhotoService profilePhotoService;

    @Override
    public ResponseEntity findAll() {
        return null;
    }

    @Override
    public ResponseEntity findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity save(@RequestBody RequestProfilePhotoDTO requestProfilePhotoDTO) {
        return profilePhotoService.save(requestProfilePhotoDTO);
    }

    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity update(@RequestBody RequestProfilePhotoDTO requestProfilePhotoDTO, @PathVariable("id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity findByUserIdApply(@PathVariable("id") Long userId) {
        return profilePhotoService.findByUserIdApply(userId);
    }
}
