package com.dimiaug.hello.tdd.messagevault.domain.interactors;

import com.dimiaug.hello.tdd.messagevault.domain.exceptions.UnknownMessageException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageVaultInteractorsTest {

    @Test
    public void unknownIndex_throwsUnknownMessageException() throws Exception {
        MessageVaultFacade vault = new MessageVaultFacade(
                new StorageGatewayStub_empty()
        );
        assertThrows(
                UnknownMessageException.class,
                () -> vault.getMessage(100, "key")
        );
    }

    @Test
    public void addingX_getRightMessageWithRightKey() throws Exception {
        MessageVaultFacade vault = new MessageVaultFacade(
                new StorageGatewayStub_singleMessage()
        );
        int index = vault.addMessage("message", "key");
        String message = vault.getMessage(index, "key");
        assertEquals("message", message);
    }

    @Test
    public void addingX_cannotGetRightMessageWithOtherKey() throws Exception {
        MessageVaultFacade vault = new MessageVaultFacade(
                new StorageGatewayStub_singleMessage()
        );
        int index = vault.addMessage("message", "key");
        String message = vault.getMessage(index, "other key");
        assertNotEquals("message", message);
    }

    @Test
    public void addingMessageAndGettingMessage_invokesStorage() throws Exception {
        StorageGatewaySpy_ storageSpy = new StorageGatewaySpy_();
        EncryptorStub_noEncryption encryptor = new EncryptorStub_noEncryption();

        MessageVaultFacade vault = new MessageVaultFacade(storageSpy, encryptor);

        vault.addMessage("message", "key");
        vault.getMessage(999, "key2");
        assertEquals("message", storageSpy.message);
        assertEquals(999, storageSpy.index);
    }
}
