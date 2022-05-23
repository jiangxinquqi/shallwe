## 技术选型

### 后端技术：

技术|版本|说明|官网
---|---|---|---
Spring Boot|2.0.4.RELEASE|容器|https://spring.io/projects/spring-boot
Spring Cloud|Finchley.SR1|微服务治理|https://projects.spring.io/spring-cloud/

## 分层架构

采用四层架构：

- 表现层（Presentation）
- 应用（逻辑）层（Application）
- 领域层（Domain）
- 基础设施层（Infrastructure）

宽松的分层系统表⽰： 每层都可以使⽤它的下层服务，⽽不仅仅是下⼀层的服务。 每层都可能是半透明的，这意味着有些服务只对上⼀层可见，⽽有些服务对上⾯的所有层都可见。

## 目录结构

业务域 名.层名.业务模块名.构造型名

    com.xiao.order.domain.model.*      

    com.xiao.order.infrastructure.peristent.redis
    com.xiao.order.infrastructure.peristent.mbatis
    com.xiao.order.infrastructure.peristent.jpa
    com.xiao.order.infrastructure.peristent.solr
    com.xiao.order.infrastructure.mq 

    com.xiao.order.application.*                    

    com.xiao.order.presentation.rest
    com.xiao.order.presentation.grpc
    com.xiao.order.presentation.websocket

## 模块

使用module横向分割

    shallwe【pom】
    |——order-core
    |——order-peristent
    |——order-service

    shallwe【pom】	
    |——project-tools【dir】	                            -- 一些开发工具  				
    |——project-doc【dir】	   	                        -- 项目文档			
    |——shallwe-common【jar】	                            -- 公共模块  
    |——shallwe-discovery-server-eureka【jar | war】	    --服务注册中心【端口：8761】
    |——shallwe-discovery-gateway-zuul【jar | war】	    --服务网关【端口：9000】
    |——shallwe-discovery-client-feign【jar】	            --服务调用，客户端负载均衡
    |——shallwe-spring-boot-starter【pom】	            --懒人加载包
        |——shallwe-config-spring-boot-starter【jar】     --shallwe微服务配置加载包
    |——shallwe-microservice-*【pom】                     -- 微服务
        |——shallwe-microservice-*-common【jar】          --微服务公共模块
        |——shallwe-microservice-*-dao【jar】             --微服务持久层【代码机自动生成代码】
        |——shallwe-microservice-*-api【jar】             --微服务顶层接口定义
        |——shallwe-microservice-*-service【jar | war】   --微服务提供【端口：8762 & 8763】

## 微服务打包启动方式

```shell
mvn clean package -pl com.xiao:${artifactId} -am -DskipTests
```