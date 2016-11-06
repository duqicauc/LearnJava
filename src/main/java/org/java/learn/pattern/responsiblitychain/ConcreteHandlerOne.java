package org.java.learn.pattern.responsiblitychain;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/6
 * Time: 20:01
 */
public class ConcreteHandlerOne extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() < 0) {
            System.out.println("Negative values are handled by ConcreateHandlerOne:");
            System.out.println("\tConcreteHandlerOne.HandleRequest : " + request.getDescription() + request.getValue());
        } else {
            successor.handleRequest(request);
        }
    }
}
