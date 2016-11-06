package org.java.learn.pattern.responsiblitychain;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/6
 * Time: 20:05
 */
public class ConcreteHandlerTwo extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() > 0) {
            System.out.println("Positive values are handled by ConcreateHandlerTwo:");
            System.out.println("\tConcreteHandlerTwo.HandleRequest : " + request.getDescription() + request.getValue());
        } else {
            successor.handleRequest(request);
        }
    }
}
