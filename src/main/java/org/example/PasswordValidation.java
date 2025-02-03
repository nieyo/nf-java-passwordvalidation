package org.example;

public class PasswordValidation {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static boolean validateLength(String password) {
        if(!password.isEmpty() && password.length() < 8){
            return false;
        }
        return !password.isEmpty();
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
}