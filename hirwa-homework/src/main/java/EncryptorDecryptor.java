public class EncryptorDecryptor {
    static char[] encrypted ={'!',')','"','(','£','*','%','&','>','<','@','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};
    static char[] normalChar = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static String message;

    public static void main(String[] args){
        //Decrypting
        message = "bdh£h";//moses
        decrypt(message,encrypted,normalChar);

        //Encrypting.
        message = "john"; //<d&c
        encrypt(message,encrypted,normalChar);
    }

    public static void decrypt(String message, char[] encrypted, char[] normalChar){
        //First convert the message into a character array
        char[] theMessage = new char[message.length()];

        //Copy character by character into the array
        for (int i = 0; i < message.length(); i++) {
            theMessage[i] = message.charAt(i);
        }
        //Let's prove the string was converted.
        System.out.println("The encrypted message is: ");
        for(char m: theMessage){
            System.out.println(m);
        }

        System.out.println("\nThe decrypted message is: ");
        for (int j = 0; j < theMessage.length; j++) {
            for (int i = 0; i < 26; i++) {
                if (theMessage[j] == encrypted[i]){
                    System.out.println(normalChar[i]);
                }
            }
        }
    }

    public static void encrypt(String message, char[] encrypted, char[] normalChar){
        //First convert the message into a character array
        char[] theMessage = new char[message.length()];

        //Copy character by character into the array
        for (int i = 0; i < message.length(); i++) {
            theMessage[i] = message.charAt(i);
        }
        //Let's prove the string was converted.
        System.out.println("The normal message is: ");
        for(char m: theMessage){
            System.out.println(m);
        }

        System.out.println("\nThe encrypted message is: ");
        for (int j = 0; j < theMessage.length; j++) {
            for (int i = 0; i < 26; i++) {
                if (theMessage[j] == normalChar[i]){
                    System.out.println(encrypted[i]);
                }
            }
        }
        /*OUTPUT:
            The encrypted message is:
            b
            d
            h
            £
            h

            The decrypted message is:
            m
            o
            s
            e
            s
            The normal message is:
            j
            o
            h
            n

            The encrypted message is:
            <
            d
            &
            c
         */
    }
}
