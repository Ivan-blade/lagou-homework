package com.Ivan.task05;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 夏殿千歌序
 * @date 2020/5/21 7:37
 * @description
 */
public class Server {


    public static void main(String[] args) {

        List<Socket> list = new ArrayList<>();

        new ServerThreadChat(list).start();
        new ServerThreadReceiveFile(list).start();
        new ServerThreadSendFile().start();
    }
}
