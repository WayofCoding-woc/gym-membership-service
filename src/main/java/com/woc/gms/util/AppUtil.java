package com.woc.gms.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class AppUtil {

    public static String generatePassword(){
        String lowerCaseLetters = RandomStringUtils.
                random(5, 97, 122, true, true, null, new SecureRandom());
        return lowerCaseLetters;
    }
}
