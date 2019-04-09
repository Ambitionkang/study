package cn.kfm666.springevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements SmartApplicationListener {
    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent event) {
        event.getSource();
        System.out.println("触发了监听事件"+Thread.currentThread().getName());
        System.out.println(event.getClass().getSimpleName());
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        System.out.println("事件："+eventType.getSimpleName());
        if(eventType != null && eventType == MyApplicationContextEvent.class){
            return true;
        }
        return false;
    }


}
