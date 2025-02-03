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
            String password ="12345";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.validateLength(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsEight_returnTrue(){
            // GIVEN
            String password ="12345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.validateLength(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void validateLength_whenLengthIsLongerThanEight_returnTrue(){
            // GIVEN
            String password ="123456789";
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
            String password ="12345678";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.containsDigits(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void containsDigits_whenPasswordContainsNoDigits_returnFalse(){
            // GIVEN
            String password ="abc";
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
            String password ="aBcD";
            boolean expected = true;
            // WHEN
            boolean actual = PasswordValidation.isMixedCase(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void isMixedCase_whenPasswordContainsLowerCaseOnly_returnFalse(){
            // GIVEN
            String password ="abcd";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.isMixedCase(password);
            // THEN
            assertEquals(expected, actual);
        }

        @Test
        void isMixedCase_whenPasswordContainsUpperCaseOnly_returnFalse(){
            // GIVEN
            String password ="ABCD";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.isMixedCase(password);
            // THEN
            assertEquals(expected, actual);
        }
    }

    @Nested
    class isCommon{

        @Test
        void isCommon_whenPasswordIsCommonlyUsed_returnTrue(){
            // GIVEN
            String password1 ="Password1";
            String password2 ="Aa345678";

            boolean expected1 = true;
            boolean expected2 = true;
            // WHEN
            boolean actual1 = PasswordValidation.isCommon(password1);
            boolean actual2 = PasswordValidation.isCommon(password2);
            // THEN
            assertAll(
                    () -> assertEquals(expected1, actual1),
                    () -> assertEquals(expected2, actual2)
            );

        }

        @Test
        void isCommon_whenPasswordIsNotCommonlyUsed_returnFalse(){
            // GIVEN
            String password ="s8g7sdh4dfh9";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.isCommon(password);
            // THEN
            assertEquals(expected, actual);
        }
    }

    @Nested
    class containsSpecialChars{
        @Test
        void containsSpecialChars_whenPasswordContainsSpecialChars_returnTrue(){
            // GIVEN
            String password1 ="s8g7sdh4%dfh9";
            String password2 ="s8g7sdh4=dfh9";
            boolean expected1 = true;
            boolean expected2 = true;
            // WHEN
            boolean actual1 = PasswordValidation.containsSpecialChars(password1);
            boolean actual2 = PasswordValidation.containsSpecialChars(password2);
            // THEN
            assertAll(
                    () -> assertEquals(expected1, actual1),
                    () -> assertEquals(expected2, actual2)
            );
        }

        @Test
        void containsSpecialChars_whenPasswordContainsNoSpecialChars_returnFalse(){
            // GIVEN
            String password ="s8g7sdh4dfh9";
            boolean expected = false;
            // WHEN
            boolean actual = PasswordValidation.containsSpecialChars(password);
            // THEN
            assertEquals(expected, actual);
        }
    }

    @Nested
    class createNew{
        @Test
        void createNew_whenCreateNew_passAllTests() {
            String password = PasswordValidation.createNew();

            assertAll(
                    () -> assertTrue(PasswordValidation.validateLength(password)),
                    () -> assertTrue(PasswordValidation.containsDigits(password)),
                    () -> assertTrue(PasswordValidation.isMixedCase(password)),
                    () -> assertTrue(PasswordValidation.containsSpecialChars(password)),
                    () -> assertFalse(PasswordValidation.isCommon(password))
            );
        }
    }
}