package com.ada.javapractice.math.controller;


import com.ada.javapractice.math.model.Numbers;
import com.ada.javapractice.math.service.MathService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calc")
public class MathController {

    private final MathService mathService;


    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping("/add")
    public int add(@RequestBody Numbers numbers) {
        return mathService.add(numbers);
    }

    @PostMapping("/sub")
    public int sub(@RequestBody Numbers numbers) {
        return mathService.sub(numbers);
    }

    @PostMapping("/mul")
    public int mul(@RequestBody Numbers numbers) {
        return mathService.mul(numbers);
    }

    @PostMapping("/div")
    public int div(@RequestBody Numbers numbers) {
        return mathService.div(numbers);
    }
}