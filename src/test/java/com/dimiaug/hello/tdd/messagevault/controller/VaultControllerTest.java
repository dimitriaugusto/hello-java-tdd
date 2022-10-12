package com.dimiaug.hello.tdd.messagevault.controller;

import com.dimiaug.hello.tdd.messagevault.presenter.humbleobject.VaultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VaultControllerTest {

    private MessageVaultFacadeSpy_ vaultSpy;
    private VaultController controller;
    private VaultPresenterSpy_ presenterSpy;

    @BeforeEach
    void setUp() {
        vaultSpy = new MessageVaultFacadeSpy_(
                new StorageGatewayStub_empty()
        );
        presenterSpy = new VaultPresenterSpy_(new VaultView());
        controller = new VaultController(
                vaultSpy,
                presenterSpy
        );
    }

    @Test
    public void addMessage_callsInteractorAndPresenter() throws Exception {
        controller.runCommand("add my-message key");
        assertEquals("addMessage", vaultSpy.lastCommand);
        assertEquals("my-message", vaultSpy.message);
        assertEquals("key", vaultSpy.key);

        assertEquals(0, presenterSpy.lastIndexFromController);
    }

    @Test
    public void addMessageThenGetMessage_InvokesInteractorAndPresenter() throws Exception {
        controller.runCommand("add my-message key");
        controller.runCommand("get 0 key");

        assertEquals("getMessage", vaultSpy.lastCommand);
        assertEquals(0, vaultSpy.index);
        assertEquals("key", vaultSpy.key);
        assertEquals("my-message", vaultSpy.message);

        assertEquals("my-message", presenterSpy.lastMessageFromController);
        assertEquals(0, presenterSpy.lastIndexFromController);
    }

    @Test
    public void getMessageCommand_callsRecordInteractor() throws Exception {
        controller.runCommand("get 99 key");
        assertEquals("getMessage", vaultSpy.lastCommand);
        assertEquals(99, vaultSpy.index);
        assertEquals("key", vaultSpy.key);

        assertEquals("", presenterSpy.lastMessageFromController);
    }

    @Test
    public void getMessageCommand_callsPresenterWithEmptyString() throws Exception {
        controller.runCommand("get 99 key");

        assertEquals("", presenterSpy.lastMessageFromController);
    }

    @Test
    public void wrongCommand_throwsInvalidCommandException() throws Exception {
        assertThrows(
                InvalidCommandException.class,
                () -> {
                    controller.runCommand("invalid command sent");
                    controller.runCommand("invalid command");
                    controller.runCommand("");
                    controller.runCommand(null);
                    controller.runCommand("invalid command sent with many args");
                    controller.runCommand("get ss key");
                }
        );
    }
}
