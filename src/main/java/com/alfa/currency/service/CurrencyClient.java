package com.alfa.currency.service;

import com.alfa.currency.currencyGifModel.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency", url = "${currency.api}")
public interface CurrencyClient {

    @GetMapping("/latest.json")
    Currency LatestJson(@RequestParam(name = "app_id") String app_id,
                        @RequestParam(name = "base") String base,
                        @RequestParam(name = "symbols") String symbols);

    @GetMapping("/historical/{date}.json")
    Currency HistoricalJson(@RequestParam(name = "app_id") String app_id,
                            @RequestParam(name = "base") String base,
                            @RequestParam(name = "symbols") String symbols,
                            @PathVariable String date);


}
