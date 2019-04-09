package cn.kfm666.springevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

public class MyApplicationContextEvent extends ApplicationEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MyApplicationContextEvent(ApplicationContext source) {

        super(source);
    }
}
