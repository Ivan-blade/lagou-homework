package com.Ivan.homework1;

/**
 * @author 夏殿千歌序
 * @date 2020/5/5 16:29
 * @description
 */
import java.util.*;
public class Backgammon {

    // 创建二维数组用于保存棋盘
    private char[][] chessboard = new char[17][17];

    // 构造函数初始化棋盘
    public Backgammon () {

        char[] special = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        for(int i = 1; i < chessboard.length; i++) {
            chessboard[i][0] = special[i-1];
        }
        for(int i = 1; i < chessboard[0].length; i++) {
            chessboard[0][i] = special[i-1];
        }
        for(int i = 1; i < chessboard.length;i++) {
            for(int j = 1; j < chessboard[i].length;j++) {
                chessboard[i][j] = '+';
            }
        }

        System.out.println("棋盘加载完毕，说明：落子格式遵循 1 a，表示您落在第1行第a列");
    }

    // 提示落子
    public void remind() {
        show();
        System.out.println("现在轮到黑方选手落子，请输入您的落子位置：");
        fill('b');
        System.out.println("现在轮到白方选手落子，请输入您的落子位置：");
        fill('w');
    }

    // 打印棋盘
    public void show() {
        for(int i = 0;i < chessboard.length;i++) {
            for(int j = 0;j < chessboard[i].length;j++) {
                System.out.print(chessboard[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    // 根据落子位置处理棋盘
    public void fill(char r) {
        Scanner sc = new Scanner(System.in);

        // 获取用户输入落子位置
        String[] str = sc.nextLine().split(" ");
        // 将字符串型数据转换为十进制坐标
        int row = Integer.parseInt(str[0],16) + 1;
        int col = Integer.parseInt(str[1],16) + 1;

        // 如果横纵坐标都有效并且还未落子则落子并判断是否获胜，否则递归
        if(isValid(row) && isValid(col) && chessboard[row][col] == '+') {
            chessboard[row][col] = r;
            isOver(r,row,col);
        }
        else {
            System.out.println("您落子的位置违规请重新输入！");
            fill(r);
        }
    }

    /**
     * @param val
     * @return boolean
     * @Description 如果索引在1-16之间合法，否则违规
     */
    public boolean isValid(int val) {
        return val > 0 && val < 17;
    }


    /**
     * @param r 落子方
     * @param row 落子行
     * @param col 落子列
     * @Description 判断是否获胜
     * 每个方向的判断逻辑都是将以落子点位中心的9个棋子存入数组
     * 每次存放时对索引做判断，如果合法则存入，不合法则跳过该索引
     * 再判断该数组中是否存在5个连续相同字符
     */
    public void isOver(char r,int row,int col) {

        boolean b1 = calRow(r,row,col);
        boolean b2 = calCol(r,row,col);
        boolean b3 = calObl_1(r,row,col);
        boolean b4 = calObl_2(r,row,col);
        if(b1 || b2 || b3 || b4) {
            System.out.println("游戏结束!"+r+"方获胜");
            show();
            System.exit(0);
        }
    }

    /**
     * @param r
     * @param row
     * @param col
     * @return calNum
     * @Description 将纵向九个元素中索引不越界的压入数组交给calNum方法判断是否存在5个连子
     */
    public boolean calRow(char r,int row,int col) {

        char[] tempRow = new char[9];
        for(int i = 0;i < 9;i++) {
            if(isValid(row-4+i)) {
                tempRow[i] = chessboard[row-4+i][col];
            }
        }

        return calNum(tempRow,r);
    }

    /**
     * @param r
     * @param row
     * @param col
     * @return calNum
     * @Description 将横向九个元素中索引不越界的压入数组交给calNum方法判断是否存在5个连子
     */
    public boolean calCol(char r,int row,int col) {
        char[] tempRow = new char[9];
        for(int i = 0;i < 9;i++) {
            if(isValid(col-4+i)) {
                tempRow[i] = chessboard[row][col-4+i];
            }
        }
        return calNum(tempRow,r);
    }

    /**
     * @param r
     * @param row
     * @param col
     * @return calNum
     * @Description 将捺向九个元素中索引不越界的压入数组交给calNum方法判断是否存在5个连子
     */
    public boolean calObl_1(char r,int row,int col) {
        char[] temp_cal = new char[9];

        for(int i = 0;i < 9;i++) {
            if(isValid(row-4+i) && isValid(col-4+i)) {
                temp_cal[i] = chessboard[row-4+i][col-4+i];
            }
        }

        return calNum(temp_cal,r);
    }

    /**
     * @param r
     * @param row
     * @param col
     * @return calNum
     * @Description 将撇向九个元素中索引不越界的压入数组交给calNum方法判断是否存在5个连子
     */
    public boolean calObl_2(char r,int row,int col) {
        char[] temp_cal = new char[9];

        for(int i = 0;i < 9;i++) {
            if(isValid(row+4-i) && isValid(col-4+i)) {
                temp_cal[i] = chessboard[row+4-i][col-4+i];
            }
        }

        return calNum(temp_cal,r);
    }

    /**
     * @param temp
     * @param r
     * @return boolean
     * @Description 判断一个数组中是否存在5个指定的连续相同字符
     */
    public boolean calNum(char[] temp,char r) {

        // 创建最长连续同色棋子的数量
        int num = 0;

        int cur = 0;
        while (cur < temp.length) {
            if(temp[cur] == r) {
               num++;
               if(num >= 5) return true;
            } else {
                num = 0;
            }
            cur++;
        }
        return false;
    }
}
