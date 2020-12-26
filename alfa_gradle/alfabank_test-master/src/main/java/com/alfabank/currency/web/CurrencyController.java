package com.alfabank.currency.web;

import com.alfabank.currency.service.CompareCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Controller
public class CurrencyController {

    @Autowired
    private CompareCurrencyService compareCurrencyService;
    @Value("${app.usd_base}")
    private String usdBase; /* валюта по отношению к которой смотрится курс */
    @RequestMapping("/compare_cur")
    public String getBrokerAccount(Model model) {
        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);
        String url = compareCurrencyService.compareRate(usdBase, yesterday, now);
        model.addAttribute("url",url);
        return "compare_cur";
    }
}
