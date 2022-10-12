package com.dimiaug.hello.tdd.messagevault.domain.interactors;

import com.dimiaug.hello.tdd.messagevault.domain.entities.EncryptorImpl;
import com.dimiaug.hello.tdd.messagevault.domain.entities.Encryptor;
import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;

public class MessageVaultFacade {

    private final RecordToVault recorder;
    private final RetrieveFromVault retriever;

    public MessageVaultFacade(StorageGateway storage) {
        Encryptor defaultEncryptor = new EncryptorImpl();
        this.recorder = new RecordToVault(storage, defaultEncryptor);
        this.retriever = new RetrieveFromVault(storage, defaultEncryptor);
    }

    public MessageVaultFacade(StorageGateway storage,
                              Encryptor encryptor) {
        this.recorder = new RecordToVault(storage, encryptor);
        this.retriever = new RetrieveFromVault(storage, encryptor);
    }

    public int addMessage(String message, String key) {
        return recorder.addMessage(message, key);
    }

    public String getMessage(int index, String key) {
        return retriever.getMessage(index, key);
    }
}
