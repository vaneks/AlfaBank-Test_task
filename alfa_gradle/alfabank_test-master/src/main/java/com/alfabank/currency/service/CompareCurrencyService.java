package com.alfabank.currency.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;

public interface CompareCurrencyService {

    /**
     * Сравнить курсы валют
     *
     * @param code      код валюты
     * @param prevDate предыдущая дата
     * @param today    текущая дата
     * @return ссылка на картинку
     */
    String compareRate(String code, LocalDate prevDate, LocalDate today);
}
