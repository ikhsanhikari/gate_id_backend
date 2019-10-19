package id.gate.root.gaterootbe.endpoint.impl;

import id.gate.root.gaterootbe.data.dto.request.RequestCoverPhotoDTO;
import id.gate.root.gaterootbe.endpoint.CoverPhotoEndPoint;
import id.gate.root.gaterootbe.service.CoverPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoverPhotoEndPointImpl implements CoverPhotoEndPoint {

    @Autowired
    private CoverPhotoService coverPhotoService;

    @Override
    public ResponseEntity findAll() {
        return coverPhotoService.findAll();
    }

    @Override
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return coverPhotoService.findById(id);
    }

    @Override
    public ResponseEntity save(@RequestBody RequestCoverPhotoDTO requestCoverPhotoDTO) {
        return coverPhotoService.save(requestCoverPhotoDTO);
    }

    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity update(@RequestBody RequestCoverPhotoDTO requestCoverPhotoDTO,@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity findByUserIdApply(@PathVariable("id") Long userId) {
        return coverPhotoService.findByUserIdApply(userId);
    }
}
