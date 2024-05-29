package com.ada.javapractice.service;

import com.ada.javapractice.math.model.Numbers;
import com.ada.javapractice.math.repository.MathRepository;
import com.ada.javapractice.math.service.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MathServiceTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        MathRepository mathRepository = new MathRepository();
        mathService = new MathService(mathRepository);
    }

    @Test
    void shouldPassWhenNumbersAddedCorrectly() {
        Numbers numbers = new Numbers(3, 4);
        int result = mathService.add(numbers);
        assertEquals(7, result);
    }

    @Test
    void shouldFailWhenAdditionIsIncorrect() {
        Numbers numbers = new Numbers(3, 4);
        int result = mathService.add(numbers);
        assertNotEquals(8, result);
    }

    @Test
    void shouldPassWhenNumbersSubtractedCorrectly() {
        Numbers numbers = new Numbers(4, 3);
        int result = mathService.sub(numbers);
        assertEquals(1, result);
    }

    @Test
    void shouldFailWhenSubtractionIsIncorrect() {
        Numbers numbers = new Numbers(4, 3);
        int result = mathService.sub(numbers);
        assertNotEquals(2, result);
    }

    @Test
    void shouldPassWhenNumbersMultipliedCorrectly() {
        Numbers numbers = new Numbers(3, 4);
        int result = mathService.mul(numbers);
        assertEquals(12, result);
    }

    @Test
    void shouldFailWhenMultiplicationIsIncorrect() {
        Numbers numbers = new Numbers(3, 4);
        int result = mathService.mul(numbers);
        assertNotEquals(11, result);
    }

    @Test
    void shouldPassWhenNumbersDividedCorrectly() {
        Numbers numbers = new Numbers(8, 4);
        int result = mathService.div(numbers);
        assertEquals(2, result);
    }

    @Test
    void shouldFailWhenDivisionIsIncorrect() {
        Numbers numbers = new Numbers(8, 4);
        int result = mathService.div(numbers);
        assertNotEquals(3, result);
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        Numbers numbers = new Numbers(8, 0);
        assertThrows(ArithmeticException.class, () -> mathService.div(numbers));
    }

}
