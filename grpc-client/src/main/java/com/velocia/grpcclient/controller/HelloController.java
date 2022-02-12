package com.velocia.grpcclient.controller;

import com.velocia.grpcclient.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/{name}")
    public ResponseEntity<String> getHelloMessage(@PathVariable String name) {
        return ResponseEntity.ok(helloService.hello(name));
    }
}
