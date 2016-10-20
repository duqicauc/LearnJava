package org.java.learn.callback;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/10/20
 * Time: 14:39
 */
public class CallbackTest {

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        client.sendMsg("server, Hello!");
    }
}
