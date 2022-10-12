package com.dimiaug.hello.tdd.messagevault.domain.interactors;

import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;

public class StorageGatewayStub_singleMessage implements StorageGateway {

    private String message;

    @Override
    public int addMessage(String message) {
        this.message = message;
        return 0;
    }

    @Override
    public String getMessage(int index) {
        return message;
    }
}
