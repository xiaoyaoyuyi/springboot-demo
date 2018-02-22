package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot服务启动入口，使用了@SpringBootApplication注解，
 * 会自动扫描该类子路径下所有@Controller、@Service、@Repository、@Component 等注解类
 */
@SpringBootApplication
public class DemoApplication {
    public static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}