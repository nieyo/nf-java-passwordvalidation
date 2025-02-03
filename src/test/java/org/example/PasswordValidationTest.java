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
            String password ="";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.validateLength(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsShorterThanEight_returnFalse(){
            // GIVEN
            String password ="aB345";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.validateLength(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsEight_returnTrue(){
            // GIVEN
            String password ="aB345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.validateLength(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsLongerThanEight_returnTrue(){
            // GIVEN
            String password ="aB23456789";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.validateLength(password);
            // THEN
            assertEquals(expected, actual);
        }
    }

    @Nested
    class containsDigits {

        @Test
        void containsDigits_whenPasswordContainsDigits_returnTrue(){
            // GIVEN
            String password ="aB2345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.containsDigits(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void containsDigits_whenPasswordContainsNoDigits_returnFalse(){
            // GIVEN
            String password ="aBcDeFgH";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.containsDigits(password);
            // THEN
            assertEquals(expected, actual);
        }

    }

    @Nested
    class isMixedCase {

        @Test
        void isMixedCase_whenPasswordIsMixedCase_returnTrue(){
            // GIVEN
            String password ="aBcDeF78";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.isMixedCase(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void isMixedCase_whenPasswordIsLowerCase_returnFalse(){
            // GIVEN
            String password ="abc45678";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.isMixedCase(password);
            // THEN
            assertEquals(expected, actual);
        }
    }

}