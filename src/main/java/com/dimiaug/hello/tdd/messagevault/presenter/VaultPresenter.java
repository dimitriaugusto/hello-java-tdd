package com.dimiaug.hello.tdd.messagevault.presenter;

import com.dimiaug.hello.tdd.messagevault.presenter.humbleobject.VaultView;

public class VaultPresenter {

    private final VaultView vaultView;

    public VaultPresenter(VaultView vaultView) {
        this.vaultView = vaultView;
    }

    public void printMessageGetSuccess(String message) {
        vaultView.print("Your secret message is:\n" + message);
    }

    public void printMessageAddSuccess(int messageIndex) {
        vaultView.print("message added to vault. index: " + messageIndex);
    }

    public void printWelcomeMessage() {
        vaultView.print(
                """
                        Message Vault
                        -------------

                        enter command_
                        """
        );
    }
}
