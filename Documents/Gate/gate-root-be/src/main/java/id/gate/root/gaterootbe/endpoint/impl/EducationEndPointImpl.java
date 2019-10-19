package id.gate.root.gaterootbe.endpoint.impl;

import id.gate.root.gaterootbe.data.dto.request.RequestEducationDTO;
import id.gate.root.gaterootbe.endpoint.EducationEndPoint;
import id.gate.root.gaterootbe.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationEndPointImpl implements EducationEndPoint {

    @Autowired
    private EducationService educationService;

    @Override
    public ResponseEntity findAll() {
        return educationService.findAll();
    }

    @Override
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return educationService.findById(id);
    }

    @Override
    public ResponseEntity save(@RequestBody RequestEducationDTO requestEducationDTO) {
        return educationService.save(requestEducationDTO);
    }

    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return educationService.delete(id);
    }

    @Override
    public ResponseEntity update(@RequestBody RequestEducationDTO requestEducationDTO, @PathVariable("id") Long id) {
        return educationService.update(requestEducationDTO,id);
    }
}
