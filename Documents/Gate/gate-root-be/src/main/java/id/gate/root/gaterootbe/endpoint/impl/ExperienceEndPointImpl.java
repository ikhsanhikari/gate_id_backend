package id.gate.root.gaterootbe.endpoint.impl;

import id.gate.root.gaterootbe.data.dto.request.RequestExperienceDTO;
import id.gate.root.gaterootbe.endpoint.ExperienceEndPoint;
import id.gate.root.gaterootbe.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienceEndPointImpl implements ExperienceEndPoint {

    @Autowired
    private ExperienceService experienceService;

    @Override
    public ResponseEntity findAll() {
        return experienceService.findAll();
    }

    @Override
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return experienceService.findById(id);
    }

    @Override
    public ResponseEntity save(@RequestBody RequestExperienceDTO requestExperienceDTO) {
        return experienceService.save(requestExperienceDTO);
    }

    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return experienceService.delete(id);
    }

    @Override
    public ResponseEntity update(@RequestBody RequestExperienceDTO requestExperienceDTO,@PathVariable("id") Long id) {
        return experienceService.update(requestExperienceDTO,id);
    }
}
