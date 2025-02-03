package org.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

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
        // allowed chars
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String special = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        String allChars = lowercase + uppercase + digits + special;

        // add char's from every category
        SecureRandom random = new SecureRandom();
        ArrayList<Character> passwordChars = new ArrayList<>(length);

        passwordChars.add(lowercase.charAt(random.nextInt(lowercase.length())));
        passwordChars.add(uppercase.charAt(random.nextInt(uppercase.length())));
        passwordChars.add(digits.charAt(random.nextInt(digits.length())));
        passwordChars.add(special.charAt(random.nextInt(special.length())));

        // fill the rest randomly
        for (int i = 4; i < length; i++) {
            passwordChars.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // shuffle
        Collections.shuffle(passwordChars, new SecureRandom());

        // convert list to string
        StringBuilder password = new StringBuilder(length);
        for (char c : passwordChars) {
            password.append(c);
        }

        return password.toString();

    }

    public static String createNew() {
        return createNew(8);
    }

}