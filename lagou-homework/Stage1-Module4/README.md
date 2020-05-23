# lagou-homework
+ 作业提交操作(参考：https://blog.csdn.net/HcJsJqJSSM/article/details/84558229)
    + git clone xxx
    + 进入克隆仓库
    + 添加作业文件
    + git checkout -b newbranch
    + git add .
    + git commit -m "xxx"
    + git push -u origin newbranch
+ 相关作业请看分支
    + 目前进度Stage1-Module3

### 其他
+ 课堂资源链接--https://github.com/Ivan-blade/Java_Basics_2020.04.23
+ github关于fork别人仓库的操作链接--https://blog.csdn.net/u012426298/article/details/80315149
+ 同步仓库步骤
    + fork
    + clone
    + git pull upstream master
        + 也可以替换为三步
            ```
                git fetch upstream
                // 抓取原仓库修改代码
                git checkout master
                // 切换分支
                git merge upstream/master
                // 合并分支
            ```