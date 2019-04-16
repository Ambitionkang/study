package cn.kfm666.aoptest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public Object test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        throw new IllegalArgumentException("参数错误");
//        return "成功";
    }
}
