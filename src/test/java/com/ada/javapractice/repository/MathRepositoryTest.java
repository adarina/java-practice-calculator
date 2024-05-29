package com.ada.javapractice.repository;

import com.ada.javapractice.math.model.Calculations;
import com.ada.javapractice.math.model.Operations;
import com.ada.javapractice.math.repository.MathRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathRepositoryTest {

    private MathRepository mathRepository;

    @BeforeEach
    void setUp() {
        mathRepository = new MathRepository();
    }

    @Test
    void shouldReturnNullWhenCalculationNotFound() {
        Calculations foundCalculation = mathRepository.findCalculation(1, 1, Operations.SUB);
        assertNull(foundCalculation);
    }

    @Test
    void shouldReturnCorrectCalculationForAddOperation() {
        Calculations addCalculation = new Calculations(2, 5, 7, Operations.ADD);
        mathRepository.saveCalculation(addCalculation);
        assertEquals(addCalculation, mathRepository.findCalculation(2, 5, Operations.ADD));
    }

    @Test
    void shouldReturnCorrectCalculationForSubOperation() {
        Calculations addCalculation = new Calculations(6, 5, 1, Operations.SUB);
        mathRepository.saveCalculation(addCalculation);
        assertEquals(addCalculation, mathRepository.findCalculation(6, 5, Operations.SUB));
    }

    @Test
    void shouldReturnCorrectCalculationForMulOperation() {
        Calculations addCalculation = new Calculations(2, 5, 10, Operations.MUL);
        mathRepository.saveCalculation(addCalculation);
        assertEquals(addCalculation, mathRepository.findCalculation(2, 5, Operations.MUL));
    }

    @Test
    void shouldReturnCorrectCalculationForDivOperation() {
        Calculations addCalculation = new Calculations(10, 2, 5, Operations.DIV);
        mathRepository.saveCalculation(addCalculation);
        assertEquals(addCalculation, mathRepository.findCalculation(10, 2, Operations.DIV));
    }

    @Test
    void shouldFindSavedCalculationWithAddOperation() {
        Calculations calculation = new Calculations(5, 5, 10, Operations.ADD);
        mathRepository.saveCalculation(calculation);

        Calculations foundCalculation = mathRepository.findCalculation(5, 5, Operations.ADD);
        assertNotNull(foundCalculation);
        assertEquals(calculation.getA(), foundCalculation.getA());
        assertEquals(calculation.getB(), foundCalculation.getB());
        assertEquals(calculation.getResult(), foundCalculation.getResult());
        assertEquals(calculation.getOperations(), foundCalculation.getOperations());
    }

    @Test
    void shouldFindSavedCalculationWithSubOperation() {
        Calculations calculation = new Calculations(5, 5, 0, Operations.SUB);
        mathRepository.saveCalculation(calculation);

        Calculations foundCalculation = mathRepository.findCalculation(5, 5, Operations.SUB);
        assertNotNull(foundCalculation);
        assertEquals(calculation.getA(), foundCalculation.getA());
        assertEquals(calculation.getB(), foundCalculation.getB());
        assertEquals(calculation.getResult(), foundCalculation.getResult());
        assertEquals(calculation.getOperations(), foundCalculation.getOperations());
    }

    @Test
    void shouldFindSavedCalculationWithMulOperation() {
        Calculations calculation = new Calculations(5, 5, 25, Operations.MUL);
        mathRepository.saveCalculation(calculation);

        Calculations foundCalculation = mathRepository.findCalculation(5, 5, Operations.MUL);
        assertNotNull(foundCalculation);
        assertEquals(calculation.getA(), foundCalculation.getA());
        assertEquals(calculation.getB(), foundCalculation.getB());
        assertEquals(calculation.getResult(), foundCalculation.getResult());
        assertEquals(calculation.getOperations(), foundCalculation.getOperations());
    }

    @Test
    void shouldFindSavedCalculationWithDivOperation() {
        Calculations calculation = new Calculations(5, 5, 1, Operations.DIV);
        mathRepository.saveCalculation(calculation);

        Calculations foundCalculation = mathRepository.findCalculation(5, 5, Operations.DIV);
        assertNotNull(foundCalculation);
        assertEquals(calculation.getA(), foundCalculation.getA());
        assertEquals(calculation.getB(), foundCalculation.getB());
        assertEquals(calculation.getResult(), foundCalculation.getResult());
        assertEquals(calculation.getOperations(), foundCalculation.getOperations());
    }
}
