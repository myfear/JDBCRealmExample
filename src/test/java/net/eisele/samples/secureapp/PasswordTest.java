/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eisele.samples.secureapp;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author eiselem
 */
public class PasswordTest {

    public PasswordTest() {
    }

    @Test
    public void generateTestPasswords() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = "admin";
            md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String output = bigInt.toString(16);

            System.out.println(output);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(PasswordTest.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}