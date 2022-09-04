package com.woc.gms.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class AppUtilTest {

    @Test
    public void generatePasswordTest(){
        String password = AppUtil.generatePassword();
        System.out.println(password);
        Assertions.assertNotNull(password, "Generated Password should not be null");
        Assertions.assertEquals(5, password.length(), "Generated Password should be of size 5");
    }

    @Test
    public void generateEncodedPassword(){
        String pwd = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("pwd");
        System.out.println("pwd = " + pwd);
        Assertions.assertNotNull(pwd);
    }
}
