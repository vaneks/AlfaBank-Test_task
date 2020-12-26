package com.alfabank.currency.service;

import com.alfabank.currency.dto.Currency;
import com.alfabank.currency.dto.gif.Gif;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CurrencyHelpServiceImpl implements CurrencyHelpService {
    @Value("${app.gif_url}")
    private String gifUrl;
    @Value("${app.url}")
    private String url;
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyHelpServiceImpl.class);

    /**
     * Получить курс валют на дату
     *
     * @param date дата
     * @return курс
     */


    @Override
    public Optional<Currency> getCurrency(LocalDate date) {
        try {
            FeignClient feignClient = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .logger(new Slf4jLogger(FeignClient.class))
                    .logLevel(feign.Logger.Level.FULL)
                    .target(FeignClient.class, url +date+".json?app_id=6a2f6762503541dc9d88c6f0b164e698");

            Currency currency = feignClient.getCurrency();
            LOGGER.info(currency.toString());
            return Optional.of(currency);
        } catch (Exception e) {
            LOGGER.error("getCurrency " + e);
        }
        return Optional.empty();
    }
    @Override
    public Optional<Gif> getGif(String query) {
            try {
                GifFeignClient feignGif = Feign.builder()
                        .client(new OkHttpClient())
                        .encoder(new GsonEncoder())
                        .decoder(new GsonDecoder())
                        .logger(new Slf4jLogger(GifFeignClient.class))
                        .logLevel(feign.Logger.Level.FULL)
                        .target(GifFeignClient.class, gifUrl+query);
                Gif gif = feignGif.getGif();
                LOGGER.info(gif.toString());
                    return Optional.of(gif);
            }   catch (Exception e) {
                    LOGGER.error("getGif" + e);
            }
            return Optional.empty();
        }
    }

