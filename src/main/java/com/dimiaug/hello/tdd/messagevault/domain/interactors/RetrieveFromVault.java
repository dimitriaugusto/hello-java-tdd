package com.dimiaug.hello.tdd.messagevault.domain.interactors;

import com.dimiaug.hello.tdd.messagevault.domain.exceptions.UnknownMessageException;
import com.dimiaug.hello.tdd.messagevault.domain.entities.Encryptor;
import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;

public class RetrieveFromVault {

    private final Encryptor encryptor;
    private final StorageGateway storage;

    RetrieveFromVault(StorageGateway storage, Encryptor encryptor) {
        this.encryptor = encryptor;
        this.storage = storage;
    }

    public String getMessage(int index, String key) {
        String encMessage = storage.getMessage(index);
        if (encMessage == null) {
            throw new UnknownMessageException();
        }
        return encryptor.decrypt(encMessage, key);
    }
}
