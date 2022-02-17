import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeCrackerTest {

    CodeCracker cracker = new CodeCracker();

    @Test
    void canEncryptSimpleMessage() {
        String message = cracker.encrypt("hello");
        assertEquals(message, "&£aad");
    }

    @Test
    void canEncryptMessageContainingSpace() {
        String message = cracker.encrypt("hello world");
        assertEquals(message, "&£aad ldga(");
    }

    @Test
    void canEncryptMessageContainingNumbers() {
        String message = cracker.encrypt("hello123");
        assertEquals(message, "&£aad123");
    }

    @Test
    void canEncryptMessageContainingSpecialCharacters() {
        String message = cracker.encrypt("hello wörld!");
        assertEquals(message, "&£aad löga(!");
    }

    @Test
    void canDecryptSimpleMessage() {
        String message = cracker.decrypt("&£aad");
        assertEquals(message, "hello");
    }

    @Test
    void canDecryptMessageContainingSpace() {
        String message = cracker.decrypt("&£aad ldga(");
        assertEquals(message, "hello world");
    }

    @Test
    void canDecryptMessageContainingNumbers() {
        String message = cracker.decrypt("&£aad123");
        assertEquals(message, "hello123");
    }

    @Test
    void canDecryptMessageContainingSpecialCharacters() {
        String message = cracker.decrypt("&£aad löga(!");
        assertEquals(message, "hello wörlda");
    }
}