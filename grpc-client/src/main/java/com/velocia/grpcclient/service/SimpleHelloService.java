package com.velocia.grpcclient.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {
    @Override
    public String hello(String name) {
        return "안녕하세요! " + name + "님!";
    }
}
