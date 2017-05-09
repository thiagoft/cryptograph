package br.com.thiagoft.cryptography.business;

/**
 * Created by thiagofonseca on 5/9/17.
 */
public class HelpInterface implements Interface {
    public void execute() {
        StringBuilder helpInterface = new StringBuilder();
        helpInterface.append("Set the argument (E) to encrypt or (D) to decrypt:\n")
                .append("Example: e=test to encrypt the word test or d=<encryptedWord> to decrypt the word between <>");

        System.out.println(helpInterface.toString());
    }
}
