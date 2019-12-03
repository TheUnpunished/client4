package ru.kpfu.icmit.client4.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.kpfu.icmit.client4")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
