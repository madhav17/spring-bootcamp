package com.ttn.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class I18NController {


    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/i18n")
    public String good_morning(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning", null, locale);
    }

    @GetMapping(value = "/i18n/opt")
    public String good_morning_opt() {
        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }
}
