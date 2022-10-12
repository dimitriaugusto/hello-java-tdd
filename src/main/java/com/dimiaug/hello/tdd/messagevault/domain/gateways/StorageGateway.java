package com.dimiaug.hello.tdd.messagevault.domain.gateways;

public interface StorageGateway {

    int addMessage(String message);

    String getMessage(int index);
}
