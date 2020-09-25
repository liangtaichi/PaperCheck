# 总览

| 这个作业属于哪个课程 |  https://edu.cnblogs.com/campus/gdgy/Networkengineering1834  |
| -------------------- | :----------------------------------------------------------: |
| 这个作业要求在哪里   | https://edu.cnblogs.com/campus/gdgy/Networkengineering1834/homework/11146 |
| 这个作业的目标       | 在做个人项目中学习个人开发流程；注册并第一次尝试利用软工在线网站；尝试使用Github来管理代码；第一次尝试使用单元测试 |

## psp表格

| ***\*PSP2.1\****                        | ***\*Personal Software Process Stages\**** | ***\*预估耗时（分钟）\**** | ***\*实际耗时（分钟）\**** |
| --------------------------------------- | ------------------------------------------ | -------------------------- | -------------------------- |
| Planning                                | 计划                                       | 20                         |60                            |
| · Estimate                              | · 估计这个任务需要多少时间                 | 5                          | 60                           |
| Development                             | 开发                                       | 128                        |369                            |
| · Analysis                              | · 需求分析 (包括学习新技术)                | 20                         | 77                           |
| · Design Spec                           | · 生成设计文档                             | 15                         | 16                           |
| · Design Review                         | · 设计复审                                 | 3                          | 10                           |
| · Coding Standard                       | · 代码规范 (为目前的开发制定合适的规范)    | 5                          |  5                          |
| · Design                                | · 具体设计                                 | 15                         | 60                           |
| · Coding                                | · 具体编码                                 | 50                         | 180                           |
| · Code Review                           | · 代码复审                                 | 5                          | 1                           |
| · Test                                  | · 测试（自我测试，修改代码，提交修改）     | 20                         |  20                          |
| Reporting                               | 报告                                       | 23                         | 55                           |
| · Test Repor                            | · 测试报告                                 | 10                         |  20                          |
| · Size Measurement                      | · 计算工作量                               | 5                          |  25                          |
| · Postmortem & Process Improvement Plan | · 事后总结, 并提出过程改进计划             | 8                          |   0                         |
|                                         | · 合计                                     | 151                        | 424                           |

**项目地址**
https://github.com/liangtaichi/PaperCheck
**参考：**

1.阮一峰《TF-IDF与余弦相似性的应用（二）：找出相似文章》http://www.ruanyifeng.com/blog/2013/03/cosine_similarity.html

2.jieba-analysis https://github.com/huaban/jieba-analysis

3.hanlp

**设计思路 **

1.用输入流从**命令行参数**读取两个文件，存入不同数组中。

2.利用jieba将文章词频得出，然后再用词频分量的余弦相似性得出相似系数。

3.将重复率写到**命令行中读取的**答案文件中

**使用工具**

1.hutool

2.jieba

3.maven

4.hanlp

**maven导入依赖：**

    <dependencies>
        <dependency>
            <groupId>com.huaban</groupId>
            <artifactId>jieba-analysis</artifactId>
            <version>1.0.2</version>
        </dependency>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>4.5.15</version>
        </dependency>
                <dependency>
                <groupId>com.hankcs</groupId>
                <artifactId>hanlp</artifactId>
                <version>portable-1.7.8</version>
            </dependency>
                        <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.13</version>
                <scope>test</scope>
            </dependency>
    </dependencies>


**流程图**
![](https://img2020.cnblogs.com/blog/1738692/202009/1738692-20200924231034054-1520976608.png)


**遇到的困难：**

1.自己写了一个reader类，将txt文件读入list。想通过list转string，每句放到不同string数组的不同元素，以此比较每句的向量，最终因为麻烦放弃，选择使用开源的hutool。

2.不知道怎么算重复率，直到找到用余弦向量的方法检测。

3.想通过自己设计一个分词系同，枯坐一小时无果，遂引入结巴分词。

4.maven的结巴分词只更新到1.0.2，想要用tf-idf要重新增加，直接打包最新的结巴，用idea导入。

5.结巴这部导致我耗费了很多很多时间。

6.哈希表取数总是出现空指针异常

**接口设计**
![](https://img2020.cnblogs.com/blog/1738692/202009/1738692-20200924225746698-1376844999.png)
**测试结果：**
orig.txt和orig_0.8_add.txt的比较： 0.88
**异常处理**
![](https://img2020.cnblogs.com/blog/1738692/202009/1738692-20200924232127465-1909588232.png)
