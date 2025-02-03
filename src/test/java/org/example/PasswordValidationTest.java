package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    @Test
    void validateLength_whenLengthIsEight(){
        // GIVEN
        String pass ="12345678";
        boolean expected = true;
        // WHEN
        boolean actual = PasswordValidation.validateLength(pass);
        // THEN
        assertEquals(expected, actual);
    }
}