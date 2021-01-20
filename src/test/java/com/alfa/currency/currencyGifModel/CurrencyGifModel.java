package com.alfa.currency.currencyGifModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
public class CurrencyGifModel {

        @Autowired
        JacksonTester<Currency> currencyTest;
        @Autowired
        JacksonTester<Gif> gifTest;

        @Test
        public void testGif() throws Exception {
            Gif gif = gifTest.read("/gif.json").getObject();
            Assertions.assertNotNull(gif);
            Assertions.assertEquals(
                    "https://media4.giphy.com/media/jroYByVFWtYQvoDO57/giphy.gif",
                    gif.getData().get("image_url"));
        }

        @Test
        public void testCurrency() throws Exception {
            Currency currency = currencyTest.read("/latest.json").getObject();
            Assertions.assertNotNull(currency);
            Assertions.assertEquals(Double.valueOf(74.094), currency.getRates().get("RUB"));

        }
    }
