package br.com.thiagoft.cryptography.business;

/**
 * Created by thiagofonseca on 5/9/17.
 */
public class CryptographyInterface implements Interface{
    private final String[] arguments;
    private Cryptography cryptography;

    public CryptographyInterface(String[] arguments) {
        this.arguments = arguments;
        cryptography = new Cryptography();
    }

    public void execute() {
//        if (arguments.length > 1) {
//            new HelpInterface().execute();
//            return;
//        }

        try {
            System.out.println(cryptography.encrypt(System.getProperty("e")));
        } catch (Exception e) {
        }
        try {
            System.out.println(cryptography.decrypt(System.getProperty("d")));
        } catch (Exception e) {
        }
    }
}
