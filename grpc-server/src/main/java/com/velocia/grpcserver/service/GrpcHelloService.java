package com.velocia.grpcserver.service;

import com.velocia.lib.GetHelloMessageRequest;
import com.velocia.lib.GetHelloMessageResponse;
import com.velocia.lib.HelloGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcHelloService extends HelloGrpc.HelloImplBase {
    @Override
    public void getHelloMessage(GetHelloMessageRequest request, StreamObserver<GetHelloMessageResponse> responseObserver) {
        GetHelloMessageResponse response = GetHelloMessageResponse.newBuilder()
                .setMessage("안녕하세요! " + request.getName() + "님!")
                .build();
        responseObserver.onNext(response);
        System.out.println("메세지를 전송하였습니다! 요청자이름 : " + request.getName());
        responseObserver.onCompleted();
    }
}
