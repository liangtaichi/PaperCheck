
import Utils.Reader;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        /**
         * 由于文档博客写的是用空格分开的绝对路径字符串输入，所以直接用inputfile数组来填装。
         * 只需要输入一次，所以直接用Scanner
         */
        Scanner reader = new Scanner(System.in);
        String[] inputfile = reader.nextLine().split(" ");

        /**
         *根据得到的inputfile数组的不同元素将文件装到不同的list中。
         * 由于博客文档是按照源文件-修改文件-答案文件的路径来写示例，所以数组三个元素顺序对应关系也按这个来
         * 开始是一个一个存入list，后来觉得太麻烦，于是创建reader类
         */
        List org = Reader.readTxtFile(inputfile[0]);
        List add = Reader.readTxtFile(inputfile[1]);
        List ans = Reader.readTxtFile(inputfile[2]);

        /**
         *对比，由于比较复杂，所以另开一个compare类来表示
         */



    }
}