package id.gate.root.gaterootbe.endpoint.impl;

import id.gate.root.gaterootbe.data.dto.request.RequestAchievementDTO;
import id.gate.root.gaterootbe.endpoint.AchievementEndPoint;
import id.gate.root.gaterootbe.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchievementEndPointImpl implements AchievementEndPoint {

    @Autowired
    private AchievementService achievementService;

    @Override
    public ResponseEntity findAll() {
        return achievementService.findAll();
    }

    @Override
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return achievementService.findById(id);
    }

    @Override
    public ResponseEntity save(@RequestBody RequestAchievementDTO achievementDTO) {
        return achievementService.save(achievementDTO);
    }

    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return achievementService.delete(id);
    }

    @Override
    public ResponseEntity update(@RequestBody RequestAchievementDTO requestAchievementDTO,@PathVariable("id") Long id) {
        return achievementService.update(requestAchievementDTO,id);
    }
}
