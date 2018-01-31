package dangod.wechat;

import dangod.wechat.controller.MainController;

import dangod.wechat.core.annotation.Key;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
public class WechatApplication {
	public static void main(String[] args) {
		SpringApplication.run(WechatApplication.class, args);
//		initialize();
	}
//	public static void initialize(){
//		String packageName = "dangod.wechat.service";
//		List<String> classNames = getClassName(packageName);
//		for (String className : classNames) {
//			try {
//				Class clazz = Class.forName(className);
//				Object o = clazz.newInstance();
//				if(clazz.isAnnotationPresent(Key.class)){
//					Key k = (Key)clazz.getAnnotation(Key.class);
//					MainController.map.put(k.value(), o);
//					System.out.println(k.value()+":"+o.toString());
//				}
//
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static List<String> getClassName(String packageName) {
//		String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", File.separator);
//		List<String> fileNames = getClassName(filePath, null);
//		return fileNames;
//	}
//
//	private static List<String> getClassName(String filePath, List<String> className) {
//		List<String> myClassName = new ArrayList<String>();
//		File file = new File(filePath);
//		File[] childFiles = file.listFiles();
//		for (File childFile : childFiles) {
//			if (childFile.isDirectory()) {
//				myClassName.addAll(getClassName(childFile.getPath(), myClassName));
//			} else {
//				String childFilePath = childFile.getPath();
//				childFilePath = childFilePath.substring(childFilePath.indexOf(File.separator+"classes") + 9, childFilePath.lastIndexOf("."));
//				childFilePath = childFilePath.replace(File.separator, ".");
//				myClassName.add(childFilePath);
//			}
//		}
//
//		return myClassName;
//	}
}
