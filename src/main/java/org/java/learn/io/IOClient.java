package org.java.learn.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author duqi
 * @createTime 2018-12-04 11:15
 **/
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((RemotingUtil.getLocalAddress() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}