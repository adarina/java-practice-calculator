package com.ada.javapractice.math.repository;


import com.ada.javapractice.math.model.Calculations;
import com.ada.javapractice.math.model.Operations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class MathRepository {

    private final Map<UUID, Calculations> data = new HashMap<>();

    public Calculations findCalculation(int a, int b, Operations operation) {
        for (Calculations calculation : data.values()) {
            if (calculation.getA() == a && calculation.getB() == b && calculation.getOperations() == operation) {
                return calculation;
            }
        }
        return null;
    }

    public void saveCalculation(Calculations calculation) {
        data.put(UUID.randomUUID(), calculation);
    }
}
