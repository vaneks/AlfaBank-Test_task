package com.alfabank.currency.service;

import com.alfabank.currency.dto.Currency;
import com.alfabank.currency.dto.gif.Gif;
import java.time.LocalDate;
import java.util.Optional;

public interface CurrencyHelpService {

    /**
     * Получить курс валют на дату
     *
     * @param date дата
     * @return курс
     */
    Optional<Currency> getCurrency(LocalDate date);
    Optional<Gif> getGif(String query);
}
