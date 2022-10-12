package com.dimiaug.hello.tdd.messagevault.presenter;

import com.dimiaug.hello.tdd.messagevault.presenter.humbleobject.VaultView;

public class VaultViewSpy_ extends VaultView {

    public String lastPrint;

    @Override
    public void print(String s) {
        lastPrint = s;
    }
}
