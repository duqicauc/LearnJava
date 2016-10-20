package org.java.learn.callback;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/10/20
 * Time: 14:22
 */
public class Server {
    public void getClientMsg(CSCallBack callBack, String msg) {
        System.out.println("服务端：服务端收到的客户端消息为：" + msg);

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("服务端：数据处理成功，返回成功状态 200");
        String status = "200";
        callBack.process(status);
    }
}
