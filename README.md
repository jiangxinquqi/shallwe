## 项目结构
    shallwe	
    |——project-tools	   				
    |——project-doc	   				
    |——shallwe-common	--公共模块   				
    |——shallwe-entity
    |——shallwe-dao
    |——shallwe-api	                    
        |——shallwe-api-demo	   	       
    |——shallwe-service                   
        |——shallwe-service-demo	         
    |——shallwe-web					    
        |——shallwe-web-demo				
    |——shallwe-discovery-server-eureka	
    |——shallwe-discovery-client-feign		
    |——shallwe-discovery-gateway-zuul		
    
## 包结构
    com.xiao
        --common               -公共组件
            --util             -公共组件-工具类
            --vo			   -公共组件-视图模型
            --exception		   -公共组件-自定义异常
            --constant         -公共组件-常量
         --entity              -数据实体
         --dao                 -数据访问
         --api
            --controller       -接口控制层
         --web
            --controller       -web控制层 
         --config              -项目配置       
            
       
        --config               // 项目模块配置
        --core				   // 项目基础模块
            --domain		   // 项目基础模块-数据模型
        --api                  // 微服务接口
            --feign			   // 微服务接口-调用客户端
            --interceptor	   // 微服务接口-拦截器
            --controller	   // 微服务接口-微服务实现
            --service		   // 业务层
                --impl		   // 业务层-业务实现层
            --dao	   	       // 数据访问层
        --web				   // web工程
            --interceptor	   // web工程-web拦截器
            --controller	   // web工程-web控制层
            
        