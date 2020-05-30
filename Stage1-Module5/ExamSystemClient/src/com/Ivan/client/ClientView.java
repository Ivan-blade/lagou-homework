package com.Ivan.client;

import com.Ivan.model.Title;
import com.Ivan.model.User;
import com.Ivan.model.UserMessage;

import java.io.*;
import java.util.List;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 13:23
 * @description
 */
public class ClientView {

    private ClientInitClose cic = null;
    private PrintStream ps = null;
    private BufferedReader br = null;
    private BufferedWriter bw = null;


    // 初始化参数
    public ClientView(ClientInitClose cic) {
        this.cic = cic;
        try {
            ps = new PrintStream(cic.getS().getOutputStream());
            br = new BufferedReader(new InputStreamReader(cic.getS().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 系统菜单，根据输入选择系统
    public void clientMainPage() throws IOException, ClassNotFoundException {

        System.out.println("      Exam system");
        System.out.println("--------------------------");
        System.out.print("    [1] 学员系统");
        System.out.println("    [2] 管理员系统");
        System.out.println("    [0] 退出系统");
        System.out.println("--------------------------");
        inform();

        int choose = ClientScanner.getSc().nextInt();
        switch (choose) {
            case 1:
                System.out.println("正在进入学员系统");
                clientUserLogin();
                break;
            case 2:
                System.out.println("正在进入管理员系统");
                clientManagerLogin();
                break;
            case 0:
                System.out.println("正在退出系统");
                return;
            default:
                System.out.println("输入错误，重新选择");
                break;
        }
    }

    // 普通用户登录，进入后先进行校验，校验成功，进入功能菜单
    private void clientUserLogin() throws IOException, ClassNotFoundException {
        System.out.println("请输出用户名：");
        String name = ClientScanner.getSc().next();
        System.out.println("请输入密码： ");
        String password = ClientScanner.getSc().next();
        UserMessage um = new UserMessage("userCheck",new User(name,password));
        cic.getOos().writeObject(um);

        um = (UserMessage) cic.getOis().readObject();
        if("success".equals(um.getType())) {
            System.out.println("登录成功");
            while (true) {
                clientUserMenu();
            }
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    // 普通用户功能菜单
    public void clientUserMenu() {
        System.out.println("---------------------------");
        inform();
        System.out.println("[1] 考试相关");
        System.out.println("[2] 修改密码");
        System.out.println("[3] 退出");
        String flag = ClientScanner.getSc().next();
        if("1".equals(flag)) examMenu();
        else if("2".equals(flag)) {
            try {
                userUpdate();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            ps.println("over");
            System.exit(0);
        }
    }

    // 普通用户考试菜单
    public void examMenu() {
        System.out.println("---------------------------");
        inform();
        System.out.println("[1] 考试");
        System.out.println("[2] 导出成绩");
        System.out.println("[3] 查询成绩");
        int flag = ClientScanner.getSc().nextInt();
        try {
            switch (flag) {
                case 1: examStart(); break;
                case 2: examPrint(); break;
                case 3: examSelect(); break;
                default: ps.println("over");break;
            }
        } catch (Exception e) {

        }
    }

    // 考试开始，系统收到请求后会发回所有试题，客户端自动发回数据确定交卷，服务端随机给分
    // 别问我为什么随机。。。事实上是可以在试题里增加answer字段效验的，后面有时间再改吧
    public void examStart() throws IOException, ClassNotFoundException {
        ps.println("examStart");
        System.out.println(br.readLine());
        System.out.println("输入任意值获取分数（题目是用来看的，不是用来写的，三分天注定，七分看你命）");
        String str = ClientScanner.getSc().nextLine();
        ps.println(str);
        System.out.println(br.readLine());
    }

    // 打印分数，服务器将listPoints中包含该用户的对象包装成新的list发送给客户端，客户端打印
    public void examPrint() throws IOException {
        ps.println("examPrint");
        String str = null;
        bw = new BufferedWriter(new FileWriter("f:/temp/temp/temp/"+cic.getS().getPort()+"score.txt"));
        String temp = br.readLine();
        System.out.println(temp);
        bw.write(temp);
        System.out.println("打印完成");
        bw.close();
    }

    // 服务器返回该用户的所有考试记录
    public void examSelect() throws IOException {
        ps.println("examSelect");
        System.out.println(br.readLine());
    }

    // 管理员登录
    private void clientManagerLogin() throws IOException, ClassNotFoundException {
        System.out.println("请输入管理员信息: ");
        String name = ClientScanner.getSc().next();
        System.out.println("请输入管理员密码信息: ");
        String password = ClientScanner.getSc().next();
        UserMessage um = new UserMessage("managerCheck",new User(name,password));
        cic.getOos().writeObject(um);
        System.out.println("信息发送完毕");

        um = (UserMessage) cic.getOis().readObject();
        if("success".equals(um.getType())) {
            System.out.println("登录成功");
            while (true) {
                clientManagerMenu();
            }
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    // 管理员主菜单
    public void clientManagerMenu() {
        System.out.println("---------------------------");
        inform();
        System.out.println("[1] 学员管理   [2] 考题管理");
        String flag = ClientScanner.getSc().next();
        if("1".equals(flag)) userMenu();
        else if("2".equals(flag)) titleMenu();
        else {
            ps.println("over");
            System.exit(0);
        }
    }

    // 试题菜单
    public void titleMenu(){
        System.out.println("---------------------------");
        inform();
        System.out.println("[1] 增加考题 [2] 删除考题");
        System.out.println("[3] 查找考题 [4] 修改考题");
        System.out.println("[5] 显示全部考题");
        System.out.println("[6] 从文件导入考题");
        int flag = ClientScanner.getSc().nextInt();
        try {
            switch (flag) {
                case 1: titleInsert(); break;
                case 2: titleDelete(); break;
                case 3: titleSelect(); break;
                case 4: titleUpdate(); break;
                case 5: titleShow(); break;
                case 6: titleImport(); break;
                default: ps.println("over");break;
            }
        } catch (EOFException e ) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 试题导入，数据格式必须符合(String)id  (String)content中间用空格隔开，文件末最好多一行空白
    public void titleImport() throws IOException {
        ps.println("titleImport");
        System.out.println("请输入包含考题的文件路径：");
        String path = ClientScanner.getSc().next();
        BufferedReader brTemp = new BufferedReader(new FileReader(path));
        String str = null;
        while((str = brTemp.readLine()) != null) {
            ps.println(str);
        }
        System.out.println("传输完成");
    }

    // 展示所有试题
    public void titleShow() throws IOException, ClassNotFoundException,EOFException {
        ps.println("titleShow");
        System.out.println(br.readLine());
    }

    // crud
    public void titleInsert() throws IOException {
        ps.println("titleInsert");
        System.out.println("请输入新增的考题的编号：");
        String id = ClientScanner.getSc().next();
        cic.getOos().writeObject(id);
        System.out.println("请输入新增的考题的内容：");
        String content = ClientScanner.getSc().next();
        cic.getOos().writeObject(content);
        System.out.println(br.readLine());
    }
    public void titleDelete() throws IOException {
        ps.println("titleDelete");
        System.out.println("请输入需要删除试题的编号：");
        String id = ClientScanner.getSc().next();
        cic.getOos().writeObject(id);
        System.out.println(br.readLine());
    }
    public void titleSelect() throws IOException, ClassNotFoundException {
        ps.println("titleSelect");
        System.out.println("请输入需要查找的编号：");
        String id = ClientScanner.getSc().next();
        ps.println(id);
        System.out.println(br.readLine());
    }
    public void titleUpdate() throws IOException {
        ps.println("titleUpdate");
        System.out.println("请输入您要修改的编号：");
        cic.getOos().writeObject(ClientScanner.getSc().next());
        System.out.println("请输入您修改后的编号：");
        String id = ClientScanner.getSc().next();
        System.out.println("请输入您修改后的内容：");
        String content = ClientScanner.getSc().next();
        cic.getOos().writeObject(new Title(id,content));
        System.out.println(br.readLine());
    }


    // 用户模块大同小异
    public void userMenu() {
        System.out.println("---------------------------");
        inform();
        System.out.println("[1] 增加学员 [2] 删除学员");
        System.out.println("[3] 查找学员 [4] 修改学员");
        System.out.println("[5] 显示全部学员");
        int flag = ClientScanner.getSc().nextInt();
        try {
            switch (flag) {
                case 1: userInsert(); break;
                case 2: userDelete(); break;
                case 3: userSelect(); break;
                case 4: userUpdate(); break;
                case 5: userShow(); break;
                default: ps.println("over");break;
            }
        } catch (EOFException e ) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void userShow() throws IOException, ClassNotFoundException,EOFException {
        ps.println("userShow");
        System.out.println(br.readLine());
    }

    public void userInsert() throws IOException {
        ps.println("userInsert");
        System.out.println("请输入新增的用户的名称：");
        String name = ClientScanner.getSc().next();
        cic.getOos().writeObject(name);

        System.out.println("请输入新增的用户的密码：");
        String password = ClientScanner.getSc().next();
        cic.getOos().writeObject(password);
        System.out.println(br.readLine());
    }
    public void userDelete() throws IOException {
        ps.println("userDelete");
        System.out.println("请输入需要删除的用户名：");
        String name = ClientScanner.getSc().next();
        cic.getOos().writeObject(name);
        System.out.println(br.readLine());
    }
    public void userSelect() throws IOException, ClassNotFoundException {
        ps.println("userSelect");
        System.out.println("请输入需要查找的用户名：");
        String name = ClientScanner.getSc().next();
        ps.println(name);
        System.out.println(br.readLine());
    }
    public void userUpdate() throws IOException {
        ps.println("userUpdate");
        System.out.println("请输入您要修改的用户名：");
        cic.getOos().writeObject(ClientScanner.getSc().next());
        System.out.println("请输入您修改后的用户名：");
        String name = ClientScanner.getSc().next();
        System.out.println("请输入您修改后的密码：");
        String password = ClientScanner.getSc().next();
        cic.getOos().writeObject(new User(name,password));
        System.out.println(br.readLine());
    }

    public void inform() {
        System.out.println("请选择执行功能的序号(其他序号退出)：");
    }
}
