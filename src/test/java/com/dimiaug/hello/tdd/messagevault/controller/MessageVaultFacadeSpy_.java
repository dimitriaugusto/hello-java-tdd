package com.dimiaug.hello.tdd.messagevault.controller;

import com.dimiaug.hello.tdd.messagevault.domain.gateways.StorageGateway;
import com.dimiaug.hello.tdd.messagevault.domain.interactors.MessageVaultFacade;

public class MessageVaultFacadeSpy_ extends MessageVaultFacade {

    public String lastCommand;
    public String message;
    public String key;
    public int index;

    public MessageVaultFacadeSpy_(StorageGateway storage) {
        super(storage);
    }

    @Override
    public int addMessage(String message, String key) {
        lastCommand = "addMessage";
        this.message = message;
        this.key = key;
        return 0;
    }

    @Override
    public String getMessage(int index, String key) {
        lastCommand = "getMessage";
        this.index = index;
        this.key = key;
        return message;
    }
}
