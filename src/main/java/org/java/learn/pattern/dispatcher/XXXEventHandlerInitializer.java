package org.java.learn.pattern.dispatcher;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/3
 * Time: 21:56
 */
@Component
public class XXXEventHandlerInitializer {

    @Resource
    private XXXEventDispatcher dispatcher;

    public void init() {
        dispatcher.bind(XXXEventType.event1, this::handleProcess1);
        dispatcher.bind(XXXEventType.event2, this::handleProcess2);
        dispatcher.bind(XXXEventType.event3, this::handleProcess3);
    }

    private void handleProcess1(XXXEventType eventType, XXXEventContext context) {
        //事件1的处理逻辑
    }

    private void handleProcess2(XXXEventType eventType, XXXEventContext context) {
        //事件2的处理逻辑
    }

    private void handleProcess3(XXXEventType eventType, XXXEventContext context) {
        //事件3的处理逻辑
    }
}
