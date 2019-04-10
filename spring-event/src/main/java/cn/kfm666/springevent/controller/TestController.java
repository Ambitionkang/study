package cn.kfm666.springevent.controller;

import cn.kfm666.springevent.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("")
public class TestController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ServiceImpl service;
    @GetMapping
    public String test(){
//        ExecutorService service = Executors.newFixedThreadPool(5);
////        ((AnnotationConfigApplicationContext)applicationContext).set()
////        applicationContext.
//        MyApplicationContextEvent event = new MyApplicationContextEvent(applicationContext);
////        SendMailEvent event1 = new SendMailEvent(applicationContext,"1376822651@qq.com");
//        applicationContext.publishEvent(event);
////        applicationContext.publishEvent(event1);
        System.out.println("线程："+Thread.currentThread().getName());
        service.test1();
        return "成功";
    }


}
