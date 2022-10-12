package com.dimiaug.hello.tdd.messagevault.domain.entities;

public interface Encryptor {
    String encryptMessage(String message, String key);

    String decrypt(String message, String key);
}
