package com.dimiaug.hello.tdd.messagevault.controller;

import com.dimiaug.hello.tdd.messagevault.domain.interactors.MessageVaultFacade;
import com.dimiaug.hello.tdd.messagevault.presenter.VaultPresenter;

public class VaultController {
    private final MessageVaultFacade vault;
    private final VaultPresenter presenter;

    public VaultController(MessageVaultFacade vault,
                           VaultPresenter presenter) {
        this.vault = vault;
        this.presenter = presenter;
    }

    public void runCommand(String command) {
        String[] args = command.split(" ");
        if (args.length != 3) {
            throw new InvalidCommandException("Command: " + command);
        } else if ("add".equals(args[0])) {
            add(args);
        } else if ("get".equals(args[0])) {
            get(args);
        } else {
            throw new InvalidCommandException("command not recognized");
        }
    }

    private void get(String[] args) {
        try {
            String message = vault.getMessage(
                    Integer.parseInt(args[1]),
                    args[2]
            );
            if (message == null) message = "";
            presenter.printMessageGetSuccess(message);
        } catch (NumberFormatException nfe) {
            throw new InvalidCommandException(nfe);
        }
    }

    private void add(String[] args) {
        int index = vault.addMessage(args[1], args[2]);
        presenter.printMessageAddSuccess(index);
    }
}
