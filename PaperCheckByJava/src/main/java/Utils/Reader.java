package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    /**
     * 根据路径读取文件，然后用list格式存储里面的内容，返回list
     * @param filePath 路径
     * @return list
     */
    public static List readTxtFile(String filePath){
        List list=new ArrayList();
        try {
            /**
             * GBK 常用汉字编码
             */
            String encoding="GBK";
            File file=new File(filePath);
            /**
             * 判断文件是否存在
             */
            if(file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    list.add(lineTxt);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return list;

    }
}
