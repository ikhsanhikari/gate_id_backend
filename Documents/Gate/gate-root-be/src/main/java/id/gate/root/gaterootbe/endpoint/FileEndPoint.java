package id.gate.root.gaterootbe.endpoint;

import id.gate.root.gaterootbe.data.dto.response.UploadFileResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FileEndPoint {

    @PostMapping("/uploadFile")
    UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file);

    @PostMapping("/uploadMultipleFiles")
    List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files);

    @GetMapping("/downloadFile/{fileName:.+}")
    ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request);
}
