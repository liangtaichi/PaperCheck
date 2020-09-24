
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.qianxinyao.analysis.jieba.keyword.Keyword;
import com.qianxinyao.analysis.jieba.keyword.TFIDFAnalyzer;


import java.util.HashMap;
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
         *根据得到的inputfile数组的不同元素将文件装到不同的FileReader中。
         * 然后从FileReader写入String
         */
        FileReader fileReader1 = new FileReader(inputfile[0]);
        FileReader fileReader2 = new FileReader(inputfile[1]);
        String org = fileReader1.toString();
        String add = fileReader2.toString();

        /**
         * 对比，通过hanlp分词找出相似度,提取50个关键词
         */
        HashMap< String, Double> hMap = new HashMap< String, Double>();
        TFIDFAnalyzer tfidfAnalyzer1 = new TFIDFAnalyzer();
        TFIDFAnalyzer tfidfAnalyzer2 = new TFIDFAnalyzer();
        int topN = 50;
        Double[] count = new Double[50];
        Double all = 0.0;
        int i = 0;
        Double l1 = 0.0 , l2 = 0.0;
        List<Keyword> list1 = tfidfAnalyzer1.analyze(org,topN);
        List<Keyword> list2 = tfidfAnalyzer2.analyze(add,topN);

        for(Keyword keyword:list1){
            hMap.put(keyword.getName(), keyword.getTfidfvalue());
        }
        for (Keyword keyword:list2){
            if (hMap.containsKey(keyword.getName())){
                count[i] = keyword.getTfidfvalue() * hMap.get(keyword);
                i++;
            }
        }
        for (int j = 0; j < list1.size(); j++) {
            l1 = l1 + list1.get(j).getTfidfvalue() * list1.get(j).getTfidfvalue() ;
            l2 = l2 + list2.get(j).getTfidfvalue() * list2.get(j).getTfidfvalue() ;
        }
        for (int k = 0; k < 50; k++) {
            all += count[k];
        }
        double target = all/(Math.sqrt(l1)*Math.sqrt(l2));

        /**
         * 输出到指定文件
         */
        FileWriter fileWriter = new FileWriter(inputfile[2]);
        fileWriter.write(String.valueOf(target));
    }
}