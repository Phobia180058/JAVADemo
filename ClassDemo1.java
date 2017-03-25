package ClassDemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ClassDemo1 {
  	//获得类类型的三种方式，三种方式得到结果都是一样的
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	Class c1 = User.class; //任何类中都隐藏一个静态成员变量class
	
	User u1 = new User();
	Class c2 = u1.getClass();
	
	Class c3 = Class.forName("ClassDemo.User"); //User类中必须有默认构造函数且必须为全名
	Field f1 = c1.getField("userID");
	System.out.println(f1.getClass().getName());
	
	System.out.println(c1 == c2);
	System.out.println(c1 == c3);
	
	
	
	User user = new User();
	//得到User的类类型
	Class c = user.getClass();
	//得到需要被反射的方法
	Method m = c.getMethod("print", new Class[]{int.class,int.class});
	//通过invoke来调用反射方法
	m.invoke(user, new Object[]{10,20});
	
	Method m2 = c.getMethod("print", new Class[]{String.class,String.class});
	m2.invoke(user, new String[]{"Hello","World"});
	
    }
}
