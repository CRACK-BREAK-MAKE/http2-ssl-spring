package com.crack.snap.make.http2.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohan Sharma
 */
@RestController
@Slf4j
public class Http2RestController {

    @GetMapping("/greetings")
    public ResponseEntity<String> greetings() {
        log.info("Greetings from Http2RestController");
        return ResponseEntity.ok("Hello from Http2RestController");
    }
}
