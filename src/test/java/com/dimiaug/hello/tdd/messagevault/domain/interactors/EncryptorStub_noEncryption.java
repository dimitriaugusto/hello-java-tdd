package com.dimiaug.hello.tdd.messagevault.domain.interactors;

import com.dimiaug.hello.tdd.messagevault.domain.entities.Encryptor;

public class EncryptorStub_noEncryption implements Encryptor {
    @Override
    public String encryptMessage(String message, String key) {
        return message;
    }

    @Override
    public String decrypt(String message, String key) {
        return message;
    }
}
