package com.alfa.currency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyClient currencyClient;

    @Value("${currency.app_id}")
    private String app_id;

    @Value("${currencyToCompare}")
    private String symbols;

    public int compareRates(String base){

        Double latestJson = currencyClient
                .LatestJson(app_id, base, symbols)
                .getRates()
                .get(symbols);

        String date = String.valueOf(LocalDate.now().minusDays(1));

        Double historicalJson = currencyClient
                .HistoricalJson(app_id, base, symbols, date)
                .getRates()
                .get(symbols);
        return latestJson.compareTo(historicalJson);
    }
}
