## 技术选型

### 后端技术：

技术|版本|说明|官网
---|---|---|---
Spring Boot|2.0.4.RELEASE|容器|https://spring.io/projects/spring-boot
Spring Cloud|Finchley.SR1|微服务治理|https://projects.spring.io/spring-cloud/

    
    
## 项目结构
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
    
    
## 包结构 
    com.xiao.common.util                    --系统公共组件-工具类
    com.xiao.common.vo                      --系统公共组件-视图模型
    com.xiao.common.exception               --系统公共组件-自定义异常
    com.xiao.common.constant                --系统公共组件-常量
    com.xiao.micro.*.common                       --应用公共组件（*代表具体的系统）
    com.xiao.micro.*.api                          --应用微服务定义（*代表具体的系统）
    com.xiao.micro.*.controller                   --应用controller层（*代表具体的系统）
    com.xiao.micro.*.service                      --应用service层
    com.xiao.micro.*.dao                          --应用数据模型
    com.xiao.micro.*.dao.mapper                   --应用数据模型映射
    com.xiao.micro.*.web.controller               --web工程
    
## 微服务打包启动方式
```shell
mvn clean package -pl com.xiao:${artifactId} -am -DskipTests
```