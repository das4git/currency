package com.alfa.currency.service;

import com.alfa.currency.model.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gif", url = "${gif.api}")
public interface GifClient {

    @GetMapping
    Gif getGif(@RequestParam(name = "api_key") String api_key,
               @RequestParam(name = "tag") String tag);

}
