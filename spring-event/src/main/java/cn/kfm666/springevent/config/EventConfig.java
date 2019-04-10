package cn.kfm666.springevent.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @Author: kfm
 * @date: 2019/4/10 14:22
 */

@WithStateMachine
@Slf4j
public class EventConfig {
    @OnTransition(target = "unpaid")
    public void create() {
        log.info("订单创建，待支付");
    }
    @OnTransition(source = "unpaid", target = "waiting_for_receive")
    public void pay() {
        log.info("用户完成支付，待收货");
    }
    @OnTransition(source = "waiting_for_receive", target = "done")
    public void receive() {
        log.info("用户已收货，订单完成");
    }
}
