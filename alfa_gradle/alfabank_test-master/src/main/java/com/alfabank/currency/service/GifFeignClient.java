package com.alfabank.currency.service;

import com.alfabank.currency.dto.gif.Gif;
import feign.Headers;
import feign.RequestLine;

public interface GifFeignClient {

    /**
     * Получить курс валют на дату
     *
     * @return курс
     */
    @RequestLine("GET")
    @Headers("Content-Type: application/json")
    Gif getGif();
}