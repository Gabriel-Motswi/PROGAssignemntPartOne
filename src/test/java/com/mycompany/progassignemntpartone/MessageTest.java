/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progassignemntpartone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {

     @Test
    public void testMessageID() { // Tests the messageID contains ten characters
        Message message = new Message(
                1,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        assertEquals(10, message.getMessageID().length());
        assertTrue(message.checkMessageID());
    }

    @Test
    public void testValidRecipient() { // Tests that a correctly formatted recipientt is accepted
        Message message = new Message(
                1,
                "+27718693002",
                "Hello Mike"
        );

        assertTrue(message.checkRecipientCell());
    }

    @Test
    public void testInvalidRecipient() { // Tests that an incorrectly formatted recipient is rejected
        Message message = new Message(
                1,
                "0821234567",
                "Hello Mike"
        );

        assertFalse(message.checkRecipientCell());
    }

    @Test
    public void testMessageLengthSuccess() { // Tests that a message within the limit is accepted
        Message message = new Message(
                1,
                "+27718693002",
                "Hello Mike"
        );

        assertTrue(message.checkMessageLength());
    }

    @Test
    public void testMessageLengthFailure() { // Tests that the generated message hash has the expected format
        String longMessage = "A".repeat(251);

        Message message = new Message(
                1,
                "+27718693002",
                longMessage
        );

        assertFalse(message.checkMessageLength());
    }

    @Test
    public void testMessageHash() { // Tests that the generated message hash has the expected format
        Message message = new Message(
                0,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        String expectedHash =
                message.getMessageID().substring(0, 2)
                + ":0:HITONIGHT";

        assertEquals(expectedHash, message.getMessageHash());
    }

    @Test
    public void testSendMessageChoice() { // Tests the response when the user chooses to send a message
        Message message = new Message(
                1, "+27718693002", "Hello Mike"
        );

        assertEquals(
                "Message successfully sent.",
                message.SentMessage(1)
        );
    }

    @Test
    public void testDisregardMessageChoice() { // Tests the response when the user chooses to disregard a message
        Message message = new Message(
                1, "+27718693002", "Hello Mike"
        );

        assertEquals(
                "Press 0 to delete the message.",
                message.SentMessage(2)
        );
    }

    @Test
    public void testStoreMessageChoice() { // Tests the response when the user chooses to store a message
        Message message = new Message(
                1, "+27718693002", "Hello Mike"
        );

        assertEquals(
                "Message successfully stored.",
                message.SentMessage(3)
        );
    }
}
