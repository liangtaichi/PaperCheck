import cn.hutool.core.io.file.FileWriter;
import com.qianxinyao.analysis.jieba.keyword.Keyword;
import com.qianxinyao.analysis.jieba.keyword.TFIDFAnalyzer;

import java.util.HashMap;
import java.util.List;

public class CheckIt {
    public static void check(String org, String add, FileWriter output){
        /**
         * 对比，通过hanlp分词找出相似度,提取500个关键词
         */
        HashMap< String, Double> hMap = new HashMap< String, Double>();
        TFIDFAnalyzer tfidfAnalyzer1 = new TFIDFAnalyzer();
        TFIDFAnalyzer tfidfAnalyzer2 = new TFIDFAnalyzer();
        int topN = 500;
        Double[] count = new Double[topN];
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
        for (int k = 0; k < topN; k++) {
            all += count[k];
        }
        double target = all/(Math.sqrt(l1)*Math.sqrt(l2));

        /**
         * 输出到指定文件
         */
        System.out.println(String.valueOf(target));
        output.write(String.valueOf(target));
    }
}
