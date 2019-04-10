package cn.kfm666.springevent.controller;

import cn.kfm666.springevent.enums.Events;
import cn.kfm666.springevent.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kfm
 * @date: 2019/4/10 13:40
 */
@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    StateMachine<States, Events> stateMachine;

    @GetMapping("start")
    public String start(){
        stateMachine.start();
        return "成功";
    }

    @GetMapping("pay")
    public String pay(){
        stateMachine.sendEvent(Events.pay);
        return "成功";
    }

    @GetMapping("receive")
    public String receive(){
        stateMachine.sendEvent(Events.receive);
        return "成功";
    }
}
