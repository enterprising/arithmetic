java打包成jar包相关指令及说明
具体的参考https://www.jianshu.com/p/61cfa1347894

步骤  
- javac HelloWorld.java
- 在src/main/java下面执行
jar -cvfe HelloWorld.jar net.tanpeng.java.jar.HelloWorld net/tanpeng/java/jar/HelloWorld.class
- 运行
目录：src/main/java
java -jar HelloWorld.jar