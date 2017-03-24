import java.io.FileOutputStream;
import java.io.IOException;


public class OutputFunc{
    public void outPut() throws IOException{
    	//若文件不存在则创建若存在则加在文件最后
    FileOutputStream out = new FileOutputStream("E:\\Personal\\111.txt",true); 
    
        //若文件不存在则创建若存在则删除后重建
    //FileOutputStream out = new FileOutputStream("E:\\Personal\\111.txt")
	out.write('a');    //只输出低八位
	out.write('b');
	out.write(10);
	int a = 11111;
	out.write(a>>>24);  //a为4字节，输出前8位
	out.write(a>>>16);  //中间各两个八位
	out.write(a>>>8);
	out.write(a);     //输出低八位
	byte[] gbk = "中国".getBytes();
	out.write(gbk);
	out.close();   //每次输出完记得关闭
	
	
	IOFunc.printHx("E:\\Personal\\111.txt");
    }
}
