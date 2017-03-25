package ClassDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtils {
    public static void printClassMethods(Object obj) throws ClassNotFoundException{
        Class c1 = obj.getClass();
    	//任何类中的成员方法都是一个Method类的对象
    	//getMethods()获得是所有pulic方法，包括父类的方法对象
    	Method[] m = c1.getMethods();
    	//getDeclaredMethods是获得单个类中所有自己声明的方法不包括父类
    	//Method[] m2 = c1.getDeclaredMethods();
    	for(Method method : m){
    		//得到方法返回类型
    		Class type = method.getReturnType();
    		System.out.print(type.getSimpleName());
    		System.out.print(" "+method.getName()+" (");
    		//得到方法的参数列表
    		Class[] paraType = method.getParameterTypes();
    		for(Class c:paraType){
    			System.out.print(c.getSimpleName());
    		}
    		System.out.print(")");
    		System.out.println();
    	}
    	
    	
    }
    
    public static void printClassPara(Object obj){
    	Class c1 = obj.getClass();
    	//Field类代表了一个类中的成员变量,getDeclaredFields表示得到类中所有声明的成员变量
    	//getFields只能得到类中的public变量
    	Field[] para = c1.getDeclaredFields();
    	
    	for(Field field:para){
    	   System.out.print(field.getType().getSimpleName()+" ");
    	   System.out.println(field.getName());
    	}
    }
}
