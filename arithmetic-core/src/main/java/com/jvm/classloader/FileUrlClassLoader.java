package com.jvm.classloader;

import java.io.File;
import java.net.*;

/**
 * 除了需要重写构造器外无需编写findClass()方法及其class文件的字节流转换逻辑。 比继承ClassLoader要简单很多
 */
public class FileUrlClassLoader extends URLClassLoader {

    public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }


    public static void main(String[] args) throws MalformedURLException {
        String rootDir = "/Users/enterprising/Git/IdeaProjects/arithmetic/arithmetic-core/src/main/java";
        //创建自定义文件类加载器
        File file = new File(rootDir);
        //File to URI
        URI uri = file.toURI();
        URL[] urls = {uri.toURL()};

        FileUrlClassLoader loader = new FileUrlClassLoader(urls);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("com.jvm.classloader.DemoObj");
            System.out.println(object1.newInstance().toString());

            //输出结果:I am shengsheng
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}