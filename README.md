# springboot shiro的配置
&emsp;&emsp;本项目下载下来如下结构：shiro的配置在下图这里：
![images](https://github.com/lingshufeng/images/blob/master/images/shiro%E9%A1%B9%E7%9B%AE%E6%A8%A1%E6%9D%BF2.png)
&emsp;&emsp;除了添加上图的那部分以外，还需要引入一个shiro的依赖：
```
 <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-all</artifactId>
            <version>1.3.2</version>
 </dependency>
```
&emsp;&emsp;总共shiro的配置就是上边这两个地方。
#### 如果需要运行项目的话，可以按照下边的步骤来运行
&emsp;&emsp; 1、将项目引入到开发工具中之后配好`maven`。
&emsp;&emsp; 2、将项目中的`用户角色功能表mysql.sql` 文件导入到你的`mysql`库中。
&emsp;&emsp; 3、找到项目中的`resources`文件夹下的`application.properties`文件中，修改项目中的数据库连接即可。
&emsp;&emsp; 4、启动后，账号密码分别为 admin   admin1
![images](https://github.com/lingshufeng/images/blob/master/images/shiro%E9%A1%B9%E7%9B%AE%E6%A8%A1%E6%9D%BF.png)
&emsp;&emsp; 5、如有问题，可以到 `CSDN 凌大大博客` 给我留下消息。
