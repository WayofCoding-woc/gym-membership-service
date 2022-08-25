package com.woc.gms.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppUtilTest {

    @Test
    public void generatePasswordTest(){
        String password = AppUtil.generatePassword();
        System.out.println(password);
        Assertions.assertNotNull(password, "Generated Password should not be null");
        Assertions.assertEquals(5, password.length(), "Generated Password should be of size 5");
    }
}
