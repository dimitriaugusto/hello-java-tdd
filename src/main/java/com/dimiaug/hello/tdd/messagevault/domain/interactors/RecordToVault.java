package com.dimiaug.hello.tdd.messagevault.domain.interactors;

import com.dimiaug.hello.tdd.messagevault.domain.entities.Encryptor;
import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;

public class RecordToVault {

    private final Encryptor encryptor;
    private final StorageGateway storage;

    RecordToVault(StorageGateway storage, Encryptor encryptor) {
        this.encryptor = encryptor;
        this.storage = storage;
    }

    public int addMessage(String message, String key) {
        String encMessage = encryptor.encryptMessage(message, key);
        return storage.addMessage(encMessage);
    }
}
