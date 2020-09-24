
import Utils.Reader;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.qianxinyao.analysis.jieba.keyword.Keyword;
import com.qianxinyao.analysis.jieba.keyword.TFIDFAnalyzer;


import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] arg) {
        /**
         * 由于文档博客写的是用空格分开的绝对路径字符串输入，所以直接用inputfile数组来填装。
         * 只需要输入一次，所以直接用Scanner
         */
        Scanner reader = new Scanner(System.in);
        String[] inputfile = reader.nextLine().split(" ");

        /**
         *根据得到的inputfile数组的不同元素将文件装到不同的FileReader中。
         * 然后从FileReader写入String
         */
        List reader1 = Reader.readTxtFile(inputfile[0]);
        List reader2 = Reader.readTxtFile(inputfile[1]);
        List reader3 = Reader.readTxtFile(inputfile[2]);
        FileReader fileReader1 = new FileReader(inputfile[0]);
        FileReader fileReader2 = new FileReader(inputfile[1]);
        FileWriter fileWriter = new FileWriter(inputfile[2]);
        String org = fileReader1.toString();
        String add = fileReader2.toString();

        CheckIt.check(org , add , fileWriter);
    }
}