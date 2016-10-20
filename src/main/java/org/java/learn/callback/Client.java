package org.java.learn.callback;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/10/20
 * Time: 14:22
 */
public class Client implements CSCallBack {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(final String msg) {
        System.out.println("客户端： 发送的消息为： " + msg);
        new Thread(new Runnable() {
            public void run() {
                //接口作为方法参数，其实际传入引用指向的是实现类
                server.getClientMsg(Client.this, msg);
            }
        }).start();
        System.out.println("客户端：异步发送成功");
    }

    public void process(String status) {
        System.out.println("客户端： 服务端回调状态为：" + status);
    }
}
