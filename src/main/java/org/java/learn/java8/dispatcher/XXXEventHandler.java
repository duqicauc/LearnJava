package org.java.learn.java8.dispatcher;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/3
 * Time: 22:03
 */
@FunctionalInterface
public interface XXXEventHandler {
    void handle(XXXEventType eventType, XXXEventContext context);
}
