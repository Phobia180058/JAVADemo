import java.io.File;
import java.io.IOException;


public class FileFunc {
   /*
    * 列出目录下所有的子目录
    */
	public static void fileDirectory(File file) throws IOException{
		if(!file.exists()){     //严谨地判断目录是否存在
			throw new IllegalArgumentException("目录"+file+"不存在");
		}
		if(!file.isDirectory()){    //严谨判断是否当前对象为目录
			throw new IllegalArgumentException(file+"不是目录");
		}
		File[] f = file.listFiles();
		if(f != null&&f.length>0)         //目录不为空并且长度大于0即有子目录时
		for(File file1:f){
			if(file1.isDirectory()){             //迭代访问子目录并输出最终目录
				FileFunc.fileDirectory(file1);
			}else{
				System.out.println(file1+" ");
			}
		}
	}
}
