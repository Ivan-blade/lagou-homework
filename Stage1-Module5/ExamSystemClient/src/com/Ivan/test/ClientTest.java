package com.Ivan.test;

import com.Ivan.client.ClientInitClose;
import com.Ivan.client.ClientScanner;
import com.Ivan.client.ClientView;

import java.io.IOException;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 13:15
 * @description
 */
public class ClientTest {

    public static void main(String[] args) {


        ClientInitClose cic = null;
        try {
            // 1.clientinitclose类型的引用指向clientinitclose类型的对象
            cic = new ClientInitClose();
            // 2.调用成员方法实现客户端的初始化操作
            cic.clientInit();
            // 3.声明clientview类型的引用指向clientview类型的对象
            ClientView cv = new ClientView(cic);
            cv.clientMainPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ClientScanner.closeScanner();
                cic.clientClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
