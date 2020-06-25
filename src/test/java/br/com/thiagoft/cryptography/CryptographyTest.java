package br.com.thiagoft.cryptography;

import br.com.thiagoft.cryptography.business.Cryptography;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class CryptographyTest
{

    private Cryptography cryptography;
    private final String decryptedPassword = "thiagoft123";
    private final String encryptedPassword = "B4OBW44AkxtBttuoQUdpGw==";

    @Before
    public void before() {
        cryptography = new Cryptography();
    }

    @Test
    public void testIfTheEncryptationReturnsTheCorrectAnswer()
    {
        String testedEncryptedPassword = cryptography.encrypt(decryptedPassword);

        assertEquals(this.encryptedPassword,testedEncryptedPassword);
    }

    @Test
    public void testIfTheDecryptationReturnsTheCorrectAnswer()
    {
        String testedDecryptedPassword = cryptography.decrypt(encryptedPassword);

        assertEquals(this.decryptedPassword,testedDecryptedPassword);
    }
}
