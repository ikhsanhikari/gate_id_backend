package id.gate.root.gaterootbe.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/ping")
public interface PingEndPoint {

    @GetMapping("")
    public ResponseEntity ping();
}
