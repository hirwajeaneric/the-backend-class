import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeCrackerTest {

    CodeCracker cracker = new CodeCracker();

    @Test
    void canDecryptSimpleMessage() {
        String decryptedMessage = cracker.decrypt("hello");
        assertEquals(decryptedMessage, "&£aad");
    }

    @Test
    void canDecryptMessageContainingSpace() {
        String decryptedMessage = cracker.decrypt("hello world");
        assertEquals(decryptedMessage, "&£aad ldga(");
    }

    @Test
    void canDecryptMessageContainingNumbers() {
        String decryptedMessage = cracker.decrypt("hello123");
        assertEquals(decryptedMessage, "&£aad123");
    }

    @Test
    void canDecryptMessageContainingSpecialCharacters() {
        String decryptedMessage = cracker.decrypt("hello wörld!");
        assertEquals(decryptedMessage, "&£aad löga(!");
    }

    @Test
    void canEncryptSimpleMessage() {
        String encryptedMessage = cracker.encrypt("&£aad");
        assertEquals(encryptedMessage, "hello");
    }

    @Test
    void canEncryptMessageContainingSpace() {
        String encryptedMessage = cracker.encrypt("&£aad ldga(");
        assertEquals(encryptedMessage, "hello world");
    }

    @Test
    void canEncryptMessageContainingNumbers() {
        String encryptedMessage = cracker.encrypt("&£aad123");
        assertEquals(encryptedMessage, "hello123");
    }

    @Test
    void canEncryptMessageContainingSpecialCharacters() {
        String encryptedMessage = cracker.encrypt("&£aad löga(!");
        assertEquals(encryptedMessage, "hello wörlda");
    }
}