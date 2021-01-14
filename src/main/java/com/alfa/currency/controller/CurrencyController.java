package com.alfa.currency.controller;

import com.alfa.currency.service.CurrencyService;
import com.alfa.currency.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final GifService gifService;
    private final CurrencyService currencyService;

    @GetMapping("/api/{currency}")
    public String getResult(@PathVariable(name = "currency") String base) {
        int result = currencyService.compareRates(base);
        if (result == 0) {
            return "Currency rate is the same";
        }
        if (result > 0) {
            return gifService.getUrl("Rich");
        } else {
            return gifService.getUrl("Broke") ;
        }
    }
}

