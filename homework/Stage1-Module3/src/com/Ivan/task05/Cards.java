package com.Ivan.task05;

import java.util.*;

/**
 * @author 夏殿千歌序
 * @date 2020/5/11 7:34
 * @description 牌组类用于返回洗牌后的牌组
 */
public class Cards {

    // 初始字面值数组
    private String[] data = {
            "2","3","4","5","6","7","8","9","10","J","Q","K","A",
            "2","3","4","5","6","7","8","9","10","J","Q","K","A",
            "2","3","4","5","6","7","8","9","10","J","Q","K","A",
            "2","3","4","5","6","7","8","9","10","J","Q","K","A",
            "小王","大王"};

    // 将初始数组变为集合以便调用Collections中的随机排序方法
    private List<String> dataList = Arrays.asList(data);

    // list用于返回洗牌后的结果
    private List<Card> list = new ArrayList<>();

    // 构造函数中调用随机排序（洗牌），之后依据序号和字面值创建card对象传入list
    public Cards (){
        Collections.shuffle(dataList);
        for(int i = 0;i < dataList.size();i++) {
            list.add(new Card(i,dataList.get(i)));
        }
    }

    public List<Card> getList() {
        return list;
    }

}
