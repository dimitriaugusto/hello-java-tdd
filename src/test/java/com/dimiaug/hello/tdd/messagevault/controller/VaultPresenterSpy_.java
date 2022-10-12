package com.dimiaug.hello.tdd.messagevault.controller;

import com.dimiaug.hello.tdd.messagevault.presenter.VaultPresenter;
import com.dimiaug.hello.tdd.messagevault.presenter.humbleobject.VaultView;

public class VaultPresenterSpy_ extends VaultPresenter {

    public String lastMessageFromController;
    public int lastIndexFromController = -1;

    public VaultPresenterSpy_(VaultView vaultView) {
        super(vaultView);
    }

    @Override
    public void printMessageGetSuccess(String message) {
        lastMessageFromController = message;
    }

    @Override
    public void printMessageAddSuccess(int messageIndex) {
        lastIndexFromController = messageIndex;
    }
}
