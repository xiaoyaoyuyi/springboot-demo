package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by lijian on 2017/11/21 下午3:23.
 */

@RestController
public class Weather {
    @RequestMapping("/weather/today/")
    public String today() {
        return "Sunshine";
    }

    @RequestMapping("/weather/sunshine/")
    public boolean isSunShine(String weather) {
        return Objects.equals(weather, "sunshine");
    }

    @RequestMapping("/weather/rain/")
    public boolean isRainy(String weather) {
        return Objects.equals(weather, "rainy");
    }
}


