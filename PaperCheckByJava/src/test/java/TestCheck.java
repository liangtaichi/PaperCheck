import cn.hutool.core.io.file.FileWriter;
import org.junit.Test;



class CheckItTest {
    @Test
    public void check()  {
        CheckIt checkIt = new CheckIt();
        String path1 = "src/main/resources/orig_null.txt";
        String path2 = "src/main/resources/orig.txt";
        String path3 = "src/main/resources/orig_0.8_add.txt";
        String path4 = "src/main/resources/orig_0.8_del.txt";
        String path5 = "src/main/resources/orig_0.8_dis_10.txt";
        String path6 = "src/main/resources/orig_0.8_dis_15.txt";
        FileWriter fileWriter = new FileWriter("src/main/resources/output.txt");
        checkIt.check(path1,path2,fileWriter);
    }

}
