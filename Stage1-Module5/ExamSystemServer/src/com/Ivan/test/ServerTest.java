package com.Ivan.test;

import com.Ivan.server.ServerDao;
import com.Ivan.server.ServerInitClose;

import java.io.IOException;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 13:02
 * @description 服务器采用多线程，可以连接多态客户端
 */
public class ServerTest {

    public static void main(String[] args) {

        ServerInitClose sic = null;
        try {
            sic = new ServerInitClose();
            sic.serverInit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sic.serverClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
