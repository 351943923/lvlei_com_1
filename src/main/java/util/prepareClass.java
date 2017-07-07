package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class prepareClass {
    @SuppressWarnings("rawtypes")
	static HashMap<String,HashMap>  objectMap=new HashMap<String,HashMap>();
	public String getClassPathOfThePro(String path) throws ClassNotFoundException {
		File f = new File(ClassLoader.getSystemResource("").getPath().substring(1) + path);
		
		for (File ff : f.listFiles()) {
			Class<?> class1 = Class.forName(path+"/"+f.getName());
            HashMap<String, Object> hashMap=new HashMap<String,Object>();
            
		    hashMap.put(class1.getPackage()+"/"+class1.getName(), "");
		}
		return "";
	}

	public static void main(String[] args) {
		prepareClass prepareClass = new prepareClass();
		try {
			prepareClass.getClassPathOfThePro("lvlei_com/po");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
