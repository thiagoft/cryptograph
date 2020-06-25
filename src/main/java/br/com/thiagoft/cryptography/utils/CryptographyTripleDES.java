package br.com.thiagoft.cryptography.utils;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import java.util.Base64;

public class CryptographyTripleDES {

    private Cipher cipher;
    private byte[] encryptKey;
    private KeySpec keySpec;
    private SecretKeyFactory secretKeyFactory;
    private SecretKey secretKey;

 /**
 * Method that create a new instance of class.
 * @return
 * @throws InvalidKeyException
 * @throws UnsupportedEncodingException
 * @throws NoSuchAlgorithmException
 * @throws NoSuchPaddingException
 * @throws InvalidKeySpecException
 */
    public static CryptographyTripleDES newInstance() throws InvalidKeyException, UnsupportedEncodingException,
    NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
        return new CryptographyTripleDES();
    }

 /**
 * Default Constructor.
 * @throws UnsupportedEncodingException
 * @throws NoSuchAlgorithmException
 * @throws NoSuchPaddingException
 * @throws InvalidKeyException
 * @throws InvalidKeySpecException
 */
    private CryptographyTripleDES() throws UnsupportedEncodingException, NoSuchAlgorithmException,
    NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String key = "http://www.rodrigolazoti.com.br";
        encryptKey = key.getBytes( "UTF-8" );
        cipher = Cipher.getInstance( "DESede" );
        keySpec = new DESedeKeySpec( encryptKey );
        secretKeyFactory = SecretKeyFactory.getInstance( "DESede" );
        secretKey = secretKeyFactory.generateSecret( keySpec );
    }

 /**
 * Method that encrypts a value.
 * @param value
 * @return
 * @throws InvalidKeyException
 * @throws IllegalBlockSizeException
 * @throws BadPaddingException
 * @throws UnsupportedEncodingException
 */
    public String encrypt( String value ) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
    UnsupportedEncodingException {
        cipher.init( Cipher.ENCRYPT_MODE, secretKey );
        byte[] cipherText = cipher.doFinal( value.getBytes( "UTF-8" ) );
        return Base64.getEncoder().encodeToString(cipherText);
    }

 /**
 * Methot that decrypts a value.
 * @param value
 * @return
 * @throws InvalidKeyException
 * @throws IllegalBlockSizeException
 * @throws BadPaddingException
 * @throws IOException
 */
    public String decrypt( String value ) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
    IOException {
        cipher.init( Cipher.DECRYPT_MODE, secretKey );
        byte[] decipherText = cipher.doFinal(Base64.getUrlDecoder().decode(value));
        return new String( decipherText );
    }

    

}
