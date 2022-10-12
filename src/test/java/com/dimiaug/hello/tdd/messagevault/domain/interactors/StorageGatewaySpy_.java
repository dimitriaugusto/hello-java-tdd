package com.dimiaug.hello.tdd.messagevault.domain.interactors;

import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;

public class StorageGatewaySpy_ implements StorageGateway {
    public String message;
    public int index;

    @Override
    public int addMessage(String message) {
        this.message = message;
        return 0;
    }

    @Override
    public String getMessage(int index) {
        this.index = index;
        return message;
    }
}
