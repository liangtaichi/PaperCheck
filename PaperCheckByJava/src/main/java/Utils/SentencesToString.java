package Utils;

import java.util.List;

public class SentencesToString {
    /**
     * 将list转化为一个String数组，每一句存在一个元素中
     */
    String[] ToSting(List list){
        /**
         * 计算一共有多少句号
         */
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == "。"){
                count++;
            }
        }
        String [] result = new String[count];
        while(list != null){

        }
    }
}
