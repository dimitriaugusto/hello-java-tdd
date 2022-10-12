package com.dimiaug.hello.tdd.messagevault.domain.entities;

public class EncryptorImpl implements Encryptor {
    @Override
    public String encryptMessage(String message, String key) {
        int offset = key.chars().sum() % 100;
        return message.codePoints()
                .map(chr -> chr + offset)
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                )
                .toString();
    }

    @Override
    public String decrypt(String message, String key) {
        int offset = key.chars().sum() % 100;
        return message
                .codePoints()
                .map(chr -> chr - offset)
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                )
                .toString();
    }
}
