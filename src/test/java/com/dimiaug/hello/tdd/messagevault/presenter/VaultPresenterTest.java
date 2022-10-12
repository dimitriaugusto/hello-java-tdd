package com.dimiaug.hello.tdd.messagevault.presenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VaultPresenterTest {

    private VaultPresenter presenter;
    private VaultViewSpy_ viewSpy;

    @BeforeEach
    void setUp() {
        viewSpy = new VaultViewSpy_();
        presenter = new VaultPresenter(viewSpy);
    }

    @Test
    public void addMessage_callsViewWithIndex() throws Exception {
        presenter.printMessageAddSuccess(99);

        assertEquals(
                "message added to vault. index: 99",
                viewSpy.lastPrint
        );
    }

    @Test
    public void getMessage_printsTheMessage() throws Exception {
        presenter.printMessageGetSuccess("my-message");

        assertEquals(
                "Your secret message is:\n" +
                        "my-message",
                viewSpy.lastPrint
        );
    }

    @Test
    public void printWelcomeMessage() throws Exception {
        presenter.printWelcomeMessage();

        assertEquals(
                """
                        Message Vault
                        -------------

                        enter command_
                        """,
                viewSpy.lastPrint
        );
    }
}
