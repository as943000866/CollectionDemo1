package lmg.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {

	@Test
	public void test1() throws IOException {
		// 类加载器
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1);

		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2);

		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3);

		// 掌握如下
		// 方法一
		 ClassLoader loader = this.getClass().getClassLoader();
		 InputStream is =
		 loader.getResourceAsStream("lmg\\reflection\\jdbc.properties");
		//FileInputStream is = new FileInputStream(new File("jdbc1.properties"));
		Properties pros = new Properties();
		pros.load(is);
		String name = pros.getProperty("user");
		System.out.println(name);

		String password = pros.getProperty("password");
		System.out.println(password);
		
	}

}
