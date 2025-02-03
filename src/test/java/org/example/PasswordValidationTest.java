package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    @Nested
    class validateLength {

        @Test
        void validateLength_whenLengthIsZero(){
            // GIVEN
            String pass ="";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.validateLength(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsShorterThanEight(){
            // GIVEN
            String pass ="aB345";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.validateLength(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsEight(){
            // GIVEN
            String pass ="aB345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.validateLength(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsLongerThanEight(){
            // GIVEN
            String pass ="aB23456789";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.validateLength(pass);
            // THEN
            assertEquals(expected, actual);
        }
    }

    @Nested
    class containsDigits {

        @Test
        void containsDigits_whenPasswordContainsDigits(){
            // GIVEN
            String pass ="aB2345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.containsDigits(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void containsDigits_whenPasswordContainsNoDigits(){
            // GIVEN
            String pass ="aBcDeFgH";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.containsDigits(pass);
            // THEN
            assertEquals(expected, actual);
        }

    }


}