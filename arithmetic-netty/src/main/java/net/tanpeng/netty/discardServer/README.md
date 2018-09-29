netty模型  
具体的去语雀看笔记  
大概是这样的流程

1、ChannelInitializer里面放handler，pipeline形式，可以放很多个。netty编程，最主要的就是写handler  

2、ChannelInitializer放在bootstrap里面  

3、bootstrap去绑定端口、IP等，用来创建连接  

4、第3步返回的是channel，channel是netty基本概念，主要为了避免直接使用Socket，是对socket的封装，是netty中的基础组件  

5、netty的writeAndFlush、打开关闭之类的操作都是基于channel的