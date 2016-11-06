package org.java.learn.pattern.responsiblitychain;

/**
 * 关键类：处理器基类；
 * 使用：具体的处理器会基础该类，然后通过successor链接起来
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/6
 * Time: 19:59
 */
public abstract class Handler {
    protected Handler successor; //关键点1：职责链上的下一个请求处理者

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Request request); //关键点2：处理请求的方法
}
