package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.example.demo.DemoApplication.logger;

/**
 * Created by lijian on 2017/8/2 上午10:14.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello/")
    public String index() {
        String string = "Hello SpringBoot";
        logger.info(string);
        return string;
    }

    @RequestMapping("/world/")
    public String world() {
        return "Hello World";
    }

    @RequestMapping("/when/")
    public String when() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(now);
    }

    @RequestMapping(value = "/weather/", params = {"city"})
    public String weather(
            @RequestParam(value = "city") String city
    ) {
        if (Objects.equals(city, "beijing")){
            return "sunshine";
        } else if(Objects.equals(city, "jiangsu")) {
            return "rainy";
        }else {
            return "partly cloudy";
        }
    }

}
