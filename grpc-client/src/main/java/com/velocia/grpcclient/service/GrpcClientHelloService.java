package com.velocia.grpcclient.service;

import com.velocia.lib.GetHelloMessageRequest;
import com.velocia.lib.GetHelloMessageResponse;
import com.velocia.lib.HelloGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

//@Service
public class GrpcClientHelloService implements HelloService{
    @GrpcClient("GLOBAL")
    private HelloGrpc.HelloBlockingStub helloStub;

    public String hello(final String name) {
        GetHelloMessageRequest request = GetHelloMessageRequest.newBuilder().setName(name).build();
        GetHelloMessageResponse response = helloStub.getHelloMessage(request);
        return response.getMessage();
    }
}
