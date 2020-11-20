import javax.xml.transform.Source;
import java.io.*;
import java.util.SortedMap;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage:\n  java CopyFile.java <source> <target>");
            System.exit(1);
        }
        copy(args[0], args[1]);
    }

    static void copy(String source, String target) throws IOException {
        // 友情提示：测试时请使用无关紧要的文件
        // TODO:
        File file = new File(source);
        if (!file.exists()) {
            throw new FileNotFoundException("file does not exist.");
        }
        try (InputStream input = new FileInputStream(source);
             OutputStream output = new FileOutputStream(target)) {
//            int n;
//            while ((n = input.read()) != -1) {
//                output.write(n);
            byte[] buffer=new byte[1000];
            int len;
            while((len=input.read(buffer))!=-1){
                output.write(len);



            }
        }

    }
}