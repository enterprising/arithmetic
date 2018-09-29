# 序列化与反序列化
建议阅读：https://tech.meituan.com/serialization_vs_deserialization.html

我的理解：这个一般很少接触，因为基本上被框架层封装了。简单的来说就是我们在本地操作的对象，要想传输，用一般的格式是不行的，需要将其序列化：序列化后的结果可能是byte[]字节流，也可以是json对象，还可以是xml

目前遇到大json解析速度过慢的问题，期望将json换成二进制存储读取，这个坑采完之后再来补充这篇文档