package org.example;

public class PasswordValidation {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }


    public static boolean validateLength(String pass) {
        if(!pass.isEmpty() && pass.length() < 8){
            return false;
        }
        return !pass.isEmpty();
    }

    public static boolean containsDigits(String pass) {
        return true;
    }
}