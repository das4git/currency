package com.alfa.currency.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class Currency {

    @Setter
    @Getter
    private Map<String, Double> rates;


}


