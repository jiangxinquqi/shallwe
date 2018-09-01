## 技术选型
    
    
## 项目结构
    shallwe	
    |——project-tools	   				
    |——project-doc	   				
    |——shallwe-common	    --公共模块   				
    |——shallwe-demo         --demo系统
        |——shallwe-demo-common  --demo公共模块
        |——shallwe-demo-dao     --demo持久层【代码机自动生成代码】
        |——shallwe-demo-api     --demo接口
        |——shallwe-demo-service --demo微服务【端口：8762 & 8763】
        |——shallwe-demo-web     --demo前端工程（demo微服务消费者）【端口：8764】
    |——shallwe-user         --用户系统
        |——shallwe-user-common  --用户公共模块
        |——shallwe-user-dao     --用户持久层【代码机自动生成代码】
        |——shallwe-user-api     --用户接口
        |——shallwe-user-service --用户微服务【端口：8080 & 8081】
        |——shallwe-user-web-center     --用户个人中心【端口：8082】
        |——shallwe-user-web-sso     --单点系统【端口：8083】
    |——shallwe-discovery-server-eureka	    --服务注册中心【端口：8761】
    |——shallwe-discovery-client-feign	    --负载均衡	
    |——shallwe-discovery-gateway-zuul	    --服务网关【端口：9000】
    
## 包结构 
    com.xiao.common.util    --公共组件-工具类
    com.xiao.common.vo      --公共组件-视图模型
    com.xiao.common.exception   --公共组件-自定义异常
    com.xiao.common.constant    --公共组件-常量
    com.xiao.*.common   --系统公共组件（*代表具体的系统）
    com.xiao.*.api      --微服务接口（*代表具体的系统）
    com.xiao.*.api.controller   --微服务提供者（*代表具体的系统）
    com.xiao.*.dao.model    --数据模型
    com.xiao.*.dao.mapper   --数据模型映射
    com.xiao.*.web.controller   --web工程
    
        