package cn.kfm666.springevent.config;

import cn.kfm666.springevent.enums.Events;
import cn.kfm666.springevent.enums.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * Spring状态机
 * @author: kfm
 * @date: 2019/4/10 11:23
 */
@Configuration
@Slf4j
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<States, Events> {

    /**
     * 定义状态机中有哪些状态
     * @param states
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<States,Events> states) throws Exception{
        states
                .withStates()
                // 定义初始状态为待支付
                .initial(States.unpaid)
                // 制定状态定义
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.unpaid).target(States.waiting_for_receive)
                .event(Events.pay)
                .and()
                .withExternal()
                .source(States.waiting_for_receive).target(States.done)
                .event(Events.receive);
    }
    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                /*.listener(listener())*/;
    }

    // 采用注解配置更加简洁
//    @Bean
//    public StateMachineListener<States, Events> listener() {
//        return new StateMachineListenerAdapter<States, Events>() {
//            @Override
//            public void transition(Transition<States, Events> transition) {
//                if(transition.getTarget().getId() == States.unpaid) {
//                    log.info("订单创建，待支付");
//                    return;
//                }
//                if(transition.getSource().getId() == States.unpaid
//                        && transition.getTarget().getId() == States.waiting_for_receive) {
//                    log.info("用户完成支付，待收货");
//                    return;
//                }
//                if(transition.getSource().getId() == States.waiting_for_receive
//                        && transition.getTarget().getId() == States.done) {
//                    log.info("用户已收货，订单完成");
//                    return;
//                }
//            }
//        };
//    }
}
