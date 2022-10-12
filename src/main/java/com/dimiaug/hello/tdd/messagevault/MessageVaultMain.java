package com.dimiaug.hello.tdd.messagevault;

import com.dimiaug.hello.tdd.messagevault.controller.VaultController;
import com.dimiaug.hello.tdd.messagevault.domain.interactors.MessageVaultFacade;
import com.dimiaug.hello.tdd.messagevault.gateways.InMemoryStorageGateway;
import com.dimiaug.hello.tdd.messagevault.presenter.VaultPresenter;
import com.dimiaug.hello.tdd.messagevault.presenter.humbleobject.VaultView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MessageVaultMain {

    private static VaultController controller;
    private static VaultPresenter presenter;

    public static void main(String[] args) {
        wireUp();
        start();
    }

    private static void wireUp() {
        InMemoryStorageGateway storage = new InMemoryStorageGateway();
        MessageVaultFacade vault = new MessageVaultFacade(storage);
        VaultView vaultView = new VaultView();
        presenter = new VaultPresenter(vaultView);
        controller = new VaultController(vault, presenter);
    }

    public static void start() {
        showWelcomeMessage();
        while (true) {
            String input = waitForUser();
            process(input);
        }
    }

    private static void process(String userCommand) {
        controller.runCommand(userCommand);
    }

    private static void showWelcomeMessage() {
        presenter.printWelcomeMessage();
    }

    static String waitForUser() {
        try {
            return new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Retrying");
            System.out.println();
            return "failed...";
        }
    }
}
