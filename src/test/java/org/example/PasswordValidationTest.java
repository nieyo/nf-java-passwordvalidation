package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    @Nested
    class validateLength {

        @Test
        void validateLength_whenLengthIsZero_returnFalse(){
            // GIVEN
            String pass ="";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.validateLength(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsShorterThanEight_returnFalse(){
            // GIVEN
            String pass ="aB345";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.validateLength(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsEight_returnTrue(){
            // GIVEN
            String pass ="aB345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.validateLength(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsLongerThanEight_returnTrue(){
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
        void containsDigits_whenPasswordContainsDigits_returnTrue(){
            // GIVEN
            String pass ="aB2345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.containsDigits(pass);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void containsDigits_whenPasswordContainsNoDigits_returnFalse(){
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