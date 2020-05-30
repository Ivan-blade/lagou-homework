package com.Ivan.server;

import com.Ivan.model.Point;
import com.Ivan.model.Title;
import com.Ivan.model.User;
import com.Ivan.model.UserMessage;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 夏殿千歌序
 * @date 2020/5/30 9:00
 * @description 服务器开启后与客户端相连的线程
 */
public class ServerThread extends Thread {

    // socket
    private Socket s;

    // 以下数据将会在客户端连接时自动初始化，客户端断开时自动更新数据
    // 注意必须是客户端正常断开，如果是服务器宕机数据会消失
    // 服务端中的所有用户数据
    private List<User> listUsers;

    // 服务端中的所有分数数据
    private List<Point> listPoints;

    // 服务端中的所有试题数据
    private List<Title> listTitles;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        // 花式流
        ObjectInputStream ois = null;
        ObjectOutputStream oosSocket = null;
        ObjectOutputStream oosUsers = null;
        ObjectOutputStream oosTitles = null;
        ObjectOutputStream oosPoints = null;
        BufferedReader br = null;
        PrintStream ps = null;

        // 判断登录是否成功
        boolean b = false;
        // 初始化数据
        listUsers = ServerInfo.getUsers() == null ? new ArrayList<>() : ServerInfo.getUsers();
        listPoints = ServerInfo.getPoints() == null ? new ArrayList<>() : ServerInfo.getPoints();
        listTitles = ServerInfo.getTitles() == null ? new ArrayList<>() : ServerInfo.getTitles();
        try {
            ois = new ObjectInputStream(s.getInputStream());
            oosSocket = new ObjectOutputStream(s.getOutputStream());
            oosUsers = new ObjectOutputStream(new FileOutputStream("f:/temp/temp/temp/Users.txt"));
            oosTitles = new ObjectOutputStream(new FileOutputStream("f:/temp/temp/temp/Titles.txt"));
            oosPoints = new ObjectOutputStream(new FileOutputStream("f:/temp/temp/temp/Points.txt"));
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());

            // 读取验证信息
            UserMessage userMessage = (UserMessage) ois.readObject();
            System.out.println("接收到的信息是：" + userMessage);

            // 根据用户类型使用不同验证方法
            if("userCheck".equals(userMessage.getType())) b = ServerDao.serverUserCheck(userMessage.getUser(),listUsers);
            else b = ServerDao.serverManagerCheck(userMessage.getUser());

            if(b) userMessage.setType("success");
            else userMessage.setType("fail");
            oosSocket.writeObject(userMessage);

            // 保存当前登录的用户对象
            User cur = userMessage.getUser();

            // 如果用户登录成功，服务器进入功能监听状态，通过客户端上传的功能字段进行操作
            if(b) {
                while (true) {
                    String str = br.readLine();
                    switch (str) {
                        case "userInsert": {
                            String name = (String)ois.readObject();
                            String password = (String)ois.readObject();
                            listUsers.add(new User(name,password));
                            ps.println("用户增加成功");
                        } break;
                        case "userDelete": {
                            String name = (String)ois.readObject();
                            User target = null;
                            for(User user : listUsers) {
                                if(name.equals(user.getName())) {
                                    target = user;
                                }
                            }
                            listUsers.remove(target);
                            ps.println("用户删除成功");
                        } break;
                        case "userSelect": {
                            String name = br.readLine();
                            boolean b1 = false;
                            for(User user : listUsers) {
                                if(name.equals(user.getName())) {
                                    ps.println(user);
                                    b1 = true;
                                }
                            }
                            if(!b1) ps.println("未找到该用户");
                        } break;
                        case "userUpdate": {
                            String name = (String) ois.readObject();
                            User user = (User) ois.readObject();
                            User target = null;
                            for(User user1 : listUsers) {
                                if(name.equals(user1.getName())) {
                                    target = user1;
                                }
                            }
                            listUsers.remove(target);
                            listUsers.add(user);
                            ps.println("修改成功");
                        } break;
                        case "userShow": {
                            ps.println(listUsers);
                        } break;
                        case "titleInsert": {
                            String id = (String)ois.readObject();
                            String content = (String)ois.readObject();
                            listTitles.add(new Title(id,content));
                            ps.println("考题增加成功");
                        } break;
                        case "titleDelete": {
                            String id = (String)ois.readObject();
                            Title target = null;
                            for(Title title : listTitles) {
                                if(id.equals(title.getId())) {
                                    target = title;
                                }
                            }
                            listTitles.remove(target);
                            ps.println("题目删除成功");
                        } break;
                        case "titleSelect": {
                            String id = br.readLine();
                            boolean b1 = false;
                            for(Title title : listTitles) {
                                if(id.equals(title.getId())) {
                                    b1 = true;
                                    ps.println(title);
                                }
                            }
                            if(!b1) ps.println("未找到该题");
                        } break;
                        case "titleUpdate": {
                            String id = (String) ois.readObject();
                            Title temp = (Title) ois.readObject();
                            Title target = null;
                            for(Title title : listTitles) {
                                if(id.equals(title.getId())) {
                                    target = title;
                                }
                            }
                            listTitles.remove(target);
                            listTitles.add(temp);
                            ps.println("修改成功");
                        } break;
                        case "titleShow": {
                            ps.println(listTitles);
                        } break;
                        case "titleImport": {
                            String strTemp = null;
                            System.out.println("开始导入数据");
                            while((strTemp = br.readLine()) != null) {
                                String[] s1 = strTemp.split(" ");
                                if(s1.length > 1) listTitles.add(new Title(s1[0],s1[1]));
                                else break;
                            }
                            System.out.println("导入完成");
                        } break;
                        case "examStart": {
                            ps.println(listTitles);
                            br.readLine();
                            Random r = new Random();
                            int point = r.nextInt(101);
                            Point temp = new Point(cur.getName(),point);
                            listPoints.add(temp);
                            ps.println(temp);
                        } break;
                        case "examSelect": {
                            List<Point> list = new ArrayList<>();
                            for(Point temp : listPoints) {
                                if(temp.getName().equals(cur.getName())) {
                                    list.add(temp);
                                }
                            }
                            ps.println(list);
                        } break;
                        case "examPrint": {
                            List<Point> list = new ArrayList<>();
                            for(Point temp : listPoints) {
                                if(temp.getName().equals(cur.getName())) {
                                    list.add(temp);
                                }
                            }
                            ps.println(list);
                        } break;
                        default: return;
                    }

                }
            } else return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                oosUsers.writeObject(listUsers);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oosTitles.writeObject(listTitles);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oosPoints.writeObject(listPoints);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ps.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oosSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
