import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReaderAndWriterDemo {
   public static void reader(String fileName ) throws IOException{
	   //构造函数初始化可以设定编码！
	   InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
	   //InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName),"utf-8");
	   int b;
	   while ((b = isr.read())!=  -1 ){
		  //需要强制类型转换否则输出为int数字，这是字符流
		   System.out.print((char)b);
		   
	   }
	   isr.close();
   }
   public static void reader2(String fileName) throws IOException{
	   InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
	   char buf[] = new char[16*1024];
	   int b;
	   while ((b = isr.read(buf,0,buf.length))!= -1 ){
		   System.out.print(b);
	   }
	   isr.close();
   }
}
