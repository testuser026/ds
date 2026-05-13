/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public Map<String, Integer> add(
            @RequestParam(name = "a") int a,
            @RequestParam(name = "b") int b
    ) {
        Map<String, Integer> response = new HashMap<>();
        response.put("result", a + b);
        return response;
    }
    
    @GetMapping("/sub")
    public Map<String, Integer> sub(
            @RequestParam(name = "a") int a,
            @RequestParam(name = "b") int b
    ) {
        Map<String, Integer> response = new HashMap<>();
        response.put("result", a - b);
        return response;
    }
}