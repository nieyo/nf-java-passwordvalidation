package org.example;

import java.security.SecureRandom;

public class PasswordValidation {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static boolean validateLength(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    public static boolean isMixedCase(String password) {
        boolean containsLowerCase = false;
        boolean containsUpperCase = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i)) && !containsLowerCase) {
                containsLowerCase = true;
            }
            if (Character.isUpperCase(password.charAt(i)) && !containsUpperCase) {
                containsUpperCase = true;
            }
        }

        return containsLowerCase && containsUpperCase;
    }

    public static boolean isCommon(String password) {
        String[] commonPasswords = {
                "Password1",
                "Aa345678"
        };

        for (String commonPassword : commonPasswords){
            if(password.equals(commonPassword)){
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialChars(String password) {

        String specialCharacters = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        for (int i = 0; i < specialCharacters.length(); i++) {
            if(password.indexOf(specialCharacters.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }

    public static String createNew(int length) {
        // needs refactoring, could end in an infinite loop
        SecureRandom random = new SecureRandom();
        int randomInt;
        String allowedChars="0123456789abcdefghijklmnopqrstuvwxyzABCDFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        String password = "";

        for (int i = 0; i < length; i++) {
            randomInt = random.nextInt(allowedChars.length());
            password = password + allowedChars.charAt(randomInt);

            if (password.length() == length) {
                if (!isMixedCase(password) || !containsDigits(password) || !containsSpecialChars(password) || isCommon(password)){
                    password = password.substring(1);
                    i--;
                }
            }
        }

        return password;
    }

    public static String createNew() {
        return createNew(8);
    }

}