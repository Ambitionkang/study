package cn.kfm666.aoptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AopTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopTestApplication.class, args);
    }

}
