package id.gate.root.gaterootbe.endpoint;


import id.gate.root.gaterootbe.data.dto.request.RequestProfilePhotoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("profile_photos")
public interface ProfilePhotoEndPoint {
    @GetMapping("")
    ResponseEntity findAll();

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable("id")  Long id);

    @PostMapping("")
    ResponseEntity save(@RequestBody RequestProfilePhotoDTO requestProfilePhotoDTO);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable("id") Long id);

    @PatchMapping("/{id}")
    ResponseEntity update(@RequestBody RequestProfilePhotoDTO requestProfilePhotoDTO, @PathVariable("id") Long id);

    @GetMapping("/userId/{id}")
    ResponseEntity findByUserIdApply(@PathVariable("id")  Long userId);

}
