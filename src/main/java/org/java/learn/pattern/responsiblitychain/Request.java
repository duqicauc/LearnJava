package org.java.learn.pattern.responsiblitychain;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/6
 * Time: 19:54
 */
public class Request {
    private int value;
    private String description;

    public Request(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
