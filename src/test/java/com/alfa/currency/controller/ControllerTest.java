package com.alfa.currency.controller;

import com.alfa.currency.currencyGifModel.Currency;
import com.alfa.currency.currencyGifModel.Gif;
import com.alfa.currency.service.CurrencyClient;
import com.alfa.currency.service.CurrencyService;
import com.alfa.currency.service.GifClient;
import com.alfa.currency.service.GifService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Map;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(CurrencyController.class)
public class ControllerTest {


    @MockBean
    CurrencyClient currencyClient;
    @MockBean
    GifClient gifClient;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CurrencyService currencyService;
    @MockBean
    GifService gifService;

    @Test
    void testGifCurrencyController() throws Exception {

        Currency latest = new Currency();
        latest.setRates(Map.of("RUB", 74.098));

        Currency historical = new Currency();
        latest.setRates(Map.of("RUB", 74.094));

        Gif gif = new Gif();
        gif.setData(Map.of("image_url",
                "https://media4.giphy.com/media/jroYByVFWtYQvoDO57/giphy.gif"));

        Mockito.when(currencyClient.LatestJson(any(), any(), any()))
                .thenReturn(latest);
        Mockito.when(currencyClient.HistoricalJson(any(), any(), any(), any()))
                .thenReturn(historical);
        Mockito.when(gifClient.getGif(any(), any()))
                .thenReturn(gif);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/USD"))
                .andExpect(status().isOk())
                .andReturn();

    }
}

