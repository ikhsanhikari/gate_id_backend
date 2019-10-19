package id.gate.root.gaterootbe.endpoint;

import id.gate.root.gaterootbe.data.dto.request.RequestCoverPhotoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cover_photos")
public interface CoverPhotoEndPoint {

    @GetMapping("")
    ResponseEntity findAll();

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable("id")  Long id);

    @PostMapping("")
    ResponseEntity save(@RequestBody RequestCoverPhotoDTO requestCoverPhotoDTO);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable("id") Long id);

    @PatchMapping("/{id}")
    ResponseEntity update(@RequestBody RequestCoverPhotoDTO requestCoverPhotoDTO, @PathVariable("id") Long id);

    @GetMapping("/userId/{id}")
    ResponseEntity findByUserIdApply(@PathVariable("id")  Long userId);
}
