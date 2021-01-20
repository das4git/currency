package com.alfa.currency.currencyGifModel;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class Currency {

    @Setter
    @Getter
    private Map<String, Double> rates;


}