package br.com.thiagoft.cryptography;

import br.com.thiagoft.cryptography.business.CryptographyInterface;
import br.com.thiagoft.cryptography.business.HelpInterface;

/**
 * Created by thiagofonseca on 5/9/17.
 */
public class Main {

    public static void main(String[] args) {
        if (args != null) {
            new CryptographyInterface(args).execute();
        } else {
            new HelpInterface().execute();
        }
    }

}
