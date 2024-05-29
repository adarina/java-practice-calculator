package com.ada.javapractice.math.service;

import com.ada.javapractice.math.model.Calculations;
import com.ada.javapractice.math.model.Numbers;
import com.ada.javapractice.math.model.Operations;
import com.ada.javapractice.math.repository.MathRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private static final Logger logger = LoggerFactory.getLogger(MathService.class);

    private final MathRepository mathRepository;

    public MathService(MathRepository mathRepository) {
        this.mathRepository = mathRepository;
    }

    public int add(Numbers numbers) {
        return calculate(numbers, Operations.ADD);
    }

    public int sub(Numbers numbers) {
        return calculate(numbers, Operations.SUB);
    }

    public int mul(Numbers numbers) {
        return calculate(numbers, Operations.MUL);
    }

    public int div(Numbers numbers) {
        if (numbers.getB() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return calculate(numbers, Operations.DIV);
    }

    private int calculate(Numbers numbers, Operations operation) {
        Calculations existingCalculation = mathRepository.findCalculation(numbers.getA(), numbers.getB(), operation);
        if (existingCalculation != null) {
            logger.info("Existing calculation found: {}, a={}, b={}, result={}", operation, numbers.getA(), numbers.getB(), existingCalculation.getResult());
            return existingCalculation.getResult();
        } else {
            int result;
            switch (operation) {
                case ADD:
                    result = numbers.getA() + numbers.getB();
                    break;
                case SUB:
                    result = numbers.getA() - numbers.getB();
                    break;
                case MUL:
                    result = numbers.getA() * numbers.getB();
                    break;
                case DIV:
                    result = numbers.getA() / numbers.getB();
                    break;
                default:
                    throw new UnsupportedOperationException("Operation not supported");
            }
            logger.info("New calculation: {}, a={}, b={}, result={}", operation, numbers.getA(), numbers.getB(), result);
            Calculations calculation = new Calculations(numbers.getA(), numbers.getB(), result, operation);
            mathRepository.saveCalculation(calculation);
            return result;
        }
    }
}
