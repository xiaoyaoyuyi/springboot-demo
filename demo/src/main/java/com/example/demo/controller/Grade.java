package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lijian on 2017/11/21 下午3:20.
 */

@RestController
public class Grade {
    @RequestMapping("/judge/")
    public String judge(@RequestParam(required = true) int grade) {
        if (grade < 60) {
            return "failed";
        } else if (grade >= 60 && grade < 80) {
            return "pass";
        } else if (grade >= 80 && grade < 90) {
            return "good";
        } else if (grade >= 90 && grade <= 100) {
            return "excellent";
        } else {
            return "invalid grade";
        }
    }

    @RequestMapping("/average/")
    public float average(@RequestParam(required = true) String course) {
        if (course == "语文") {
            return 90.0;
        } else if (course == "数学") {
            return 91.5;
        } else if (course == "英语") {
            return 85.0;
        } else if (course == "政治") {
            return 70.5;
        } else {
            return 0;
        }

    }
