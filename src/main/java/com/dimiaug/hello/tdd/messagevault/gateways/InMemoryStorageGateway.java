package com.dimiaug.hello.tdd.messagevault.gateways;

import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorageGateway implements StorageGateway {

    private final List<String> messages = new ArrayList<>();

    @Override
    public int addMessage(String message) {
        messages.add(message);
        return messages.size() - 1;
    }

    @Override
    public String getMessage(int index) {
        try {
            return messages.get(index);
        } catch (Exception e) {
            return null;
        }
    }
}
