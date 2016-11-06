package org.java.learn.pattern.responsiblitychain;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/6
 * Time: 20:08
 */
public class ConcreteHandlerThree extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() == 0) {
            System.out.println("Zero values are handled by ConcreateHandlerThree:");
            System.out.println("\tConcreteHandlerThree.HandleRequest : " + request.getDescription() + request.getValue());
        } else {
            successor.handleRequest(request);
        }
    }
}
