package com.demo.first;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class ApplicationStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("appl. is started using CommandLineRunner");
    }
}
