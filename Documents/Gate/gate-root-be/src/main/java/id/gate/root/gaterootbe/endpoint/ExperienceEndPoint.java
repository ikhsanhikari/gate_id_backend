package id.gate.root.gaterootbe.endpoint;


import id.gate.root.gaterootbe.data.dto.request.RequestExperienceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/experiences")
public interface ExperienceEndPoint {

    @GetMapping("")
    ResponseEntity findAll();

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable("id")  Long id);

    @PostMapping("")
    ResponseEntity save(@RequestBody RequestExperienceDTO requestExperienceDTO);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable("id") Long id);

    @PatchMapping("/{id}")
    ResponseEntity update(@RequestBody RequestExperienceDTO requestExperienceDTO, @PathVariable("id") Long id);
}
