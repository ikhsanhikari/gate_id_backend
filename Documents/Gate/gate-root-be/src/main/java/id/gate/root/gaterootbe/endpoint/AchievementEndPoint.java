package id.gate.root.gaterootbe.endpoint;

import id.gate.root.gaterootbe.data.dto.request.RequestAchievementDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/achievements")
public interface AchievementEndPoint {
    @GetMapping("")
    ResponseEntity findAll();

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable("id")  Long id);

    @PostMapping("")
    ResponseEntity save(@RequestBody RequestAchievementDTO requestAchievementDTO);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable("id") Long id);

    @PatchMapping("/{id}")
    ResponseEntity update(@RequestBody RequestAchievementDTO requestUserDTO, @PathVariable("id") Long id);
}
