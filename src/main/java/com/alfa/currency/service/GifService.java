package com.alfa.currency.service;

import com.alfa.currency.currencyGifModel.Gif;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GifService {

    private final GifClient gifClient;

    @Value("${gif.api_key}")
    private String api_key;

    public String getUrl(String tag) {
        Gif gif = gifClient.getGif(api_key, tag);
        return (String)gif.getData().get("image_url");
    }
}

