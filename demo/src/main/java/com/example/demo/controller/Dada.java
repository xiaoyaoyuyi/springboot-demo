package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lijian on 2017/11/21 下午3:20.
 */

@RestController
public class Dada {
    @RequestMapping("/groups/")
    public String groups() {
        return "qa";
    }
}
