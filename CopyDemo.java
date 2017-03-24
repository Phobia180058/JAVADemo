import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class CopyDemo {
     public static void Copy1(String srcName,String destFile) throws IOException{
    	 //单纯的字节流输入输出来复制文件,读写文件用FileInput/OutputStream
    	 FileInputStream is = new FileInputStream(srcName);
    	 FileOutputStream os = new FileOutputStream(destFile);
    	 int b;
    	 //当读到末尾时则开始写入
    	 while (( b = is.read())!= -1){
    		 os.write(b);
    	 }
    	 //记得关闭流
    	 is.close();
    	 os.close();
    	 System.out.println("success");
     }
     public static void Copy2(String srcName,String destFile) throws IOException{
    	 //采用自己设的带缓冲的字节流来复制文件
    	 FileInputStream is = new FileInputStream(srcName);
    	 FileOutputStream os = new FileOutputStream(destFile);
    	 //设置缓冲区大小
    	 byte buf[] = new byte[16*1024];
    	 int b;
    	 while((b = is.read(buf,0,buf.length))!= -1 ){
    		 os.write(buf, 0, b);
    		 //带缓冲的输出时必须用flush()刷新缓冲
    		 os.flush();
    	 }
    	 is.close();
    	 os.close();
    	 System.out.println("success");
     }
     
     public static void Copy3(String srcName,String destFile) throws IOException{
    	 //采用自带的带缓冲区的字节流复制文件
    	 BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcName));
    	 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
    	 
    	 int b;
    	 while((b = bis.read())!= -1 ){
    		 bos.write(b);
    		 //输出流输出完必须刷新
    		 bos.flush();
    	 }
    	 
    	 bos.close();
    	 bis.close();
    	 System.out.println("success");
    	 
     }
}
