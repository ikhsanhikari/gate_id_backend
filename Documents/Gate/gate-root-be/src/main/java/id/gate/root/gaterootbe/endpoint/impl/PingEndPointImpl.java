package id.gate.root.gaterootbe.endpoint.impl;

import id.gate.root.gaterootbe.endpoint.PingEndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingEndPointImpl implements PingEndPoint {
    @Override
    public ResponseEntity ping() {
        return ResponseEntity.ok("PONG");
    }
}
