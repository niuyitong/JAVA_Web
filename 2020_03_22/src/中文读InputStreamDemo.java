import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class 中文读InputStreamDemo {
    public static void main(String[] args) throws IOException {

        //字符集编码不同，解读出来的内容也不同

        //将文本编码设置为UTF-8
        try (InputStream is = new FileInputStream("中文输入utf8.txt")) {
            readContent(is, "UTF-8");//用UTF_8解码
        }

        System.out.println("=========================");

        //将文本编码设置为GB18030
        try (InputStream is = new FileInputStream("中文输入gb18030.txt")) {//文件名
            readContent(is, "GB18030");
        }
    }

    private static void readContent(InputStream is, String charset) throws IOException {
        byte[] buf = new byte[8192];
        int len;

        // 这里利用了一个特性，buf 可以一次性的把所有数据都都进来
        while ((len = is.read(buf)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.println(buf[i]);
            }
            //解码 将ASCII解读成汉字(传入不同的charset则解读出来的内容不同)
            String s = new String(buf, 0, len, charset);
            System.out.println(s);
        }
    }
}
