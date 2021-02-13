## Spring框架概述

## 1、Spring全家桶

### 包括：Spring、Springboot、springMVC、Springcloud等等

```
我们现在要学的就是Spring，出现在2002年，用来降低企业级开发的难度。主要是降低对项目的模块之间的关系管理、类和类之间的关系管理的难度。通过帮助开发人员创建对象，来完成对象之间的关系管理。
```

### spring的核心技术：IOC（控制反转）和AOP（切面编程）

### 主要作用：实现项目中模块与模块、类与类之间的关系的解耦合

```
spring中对依赖的管理主要是针对项目中开发人员所写的各种类之间的依赖关系进行管理，并不是对项目所需要的其他项目的jar包的依赖管理。
Maven框架才是对需要的其他依赖项目的jar包资源进行管理的主要框架
```

## 2、浏览Spring官方：spring.io

### 首页如下

![](F:\Git_Repositories\Spring\截图\spring概述\1.png)

### 我们点击Projects，可以看到很多spring的框架，Springboot、Spring Framework、Spring Cloud...而SpringFramework就是最先出现的spring框架，平常说的spring框架在Spring官网中就是Spring Framwork项目

### SpringFramework的特性：核心技术    如下图

![](F:\Git_Repositories\Spring\截图\spring概述\2.png)

### 点击LEARN，可以下载该框架的资源，说明文档可以自己到网络中寻找中文版本的

![](F:\Git_Repositories\Spring\截图\spring概述\3.png)

## 3、Spring的特点

### 1）、轻量级框架

```
Spring框架本身使用的jar包很小，实现Spring核心功能的jar包总共不超过3M左右。
所以Spring在整个项目中占用的资源少，运行效率很高。并且不依赖外部的jar包。
```

### 2）、针对接口编程，使项目解耦合

```
面向接口开发，面向父类开发，使代码与代码之间的耦合度降低，降低后期的维护成本，提高了代码的扩展性
```

### 3）、支持AOP编程

### 4）、可以方便集成各种优秀的框架

```
集成各种优秀的框架如Struts、MyBatis等，降低了其他框架的使用难度，简化优秀框架的使用。
```

## 4、Spring的体系结构

### 就是Spring内部的组成部分，Spring有20多个模块组成，共分为

### 数据访问/集成（Data Access/Integration）

### Web模块

### 面向切面编程（AOP、Aspects）

### 提供JVM的代理（Instrumentation）

### 消息发送（Messagine）

### 核心容器（Core Container）

### 测试（Test）

![](F:\Git_Repositories\Spring\截图\spring概述\4.png)

## 5、学习框架

### 1）、首先要知道框架是一个软件，别人写好了的，或者说就是别人写好的有特定功能的jar包

### 2）、知道框架能做什么，mybatis框架：是连接数据库，对表中数据进行增删改查等等

### 3）、知道框架的语法，框架要怎么完成一个功能，需要进行说明操作步骤

### 4）、了解框架的内部实现，是怎么个实现原理。

### 5）、最后通过学习，自己实现一个框架

