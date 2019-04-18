package cn.kfm666.aoptest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class TestController implements BeanSelfProxyAware{

    TestController self = null;

    @GetMapping("/")
    public Object test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
//        throw new IllegalArgumentException("参数错误");
        self.testSelfProxy();
        return "成功";
    }

    public void testSelfProxy(){
        System.out.println("调用testSelfProxy方法");
    }

    @Override
    public void setSelfProxy(Object o) {
        this.self = (TestController) o;
    }
}
