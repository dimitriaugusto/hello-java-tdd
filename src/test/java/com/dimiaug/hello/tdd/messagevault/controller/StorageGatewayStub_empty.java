package com.dimiaug.hello.tdd.messagevault.controller;

import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;

public class StorageGatewayStub_empty implements StorageGateway {
    @Override
    public int addMessage(String message) {
        return 0; // noop
    }

    @Override
    public String getMessage(int index) {
        return null;
    }
}
