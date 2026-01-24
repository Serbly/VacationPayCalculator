package org.example.vacationcalculator.controller;

import lombok.RequiredArgsConstructor;
import org.example.vacationcalculator.dto.VacationPayRequest;
import org.example.vacationcalculator.dto.VacationPayResponse;
import org.example.vacationcalculator.service.VacationPayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class VacationPayController {
    private final VacationPayService service;

    @GetMapping("/calculate")
    public ResponseEntity<VacationPayResponse> calculateVacationPay(@Valid VacationPayRequest request) {
        return ResponseEntity.ok(service.calculateVacationPay(request));
    }
}
