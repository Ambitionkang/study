package cn.kfm666.springevent;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

    @Async
    public void test1(){
        System.out.println("test1："+Thread.currentThread().getName());
    }
}
