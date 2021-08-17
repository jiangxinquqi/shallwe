package com.xiao.dao.mapper;

import com.xiao.common.support.BaseMapper;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.ParameterizedType;

/**
 * DAO层单元测试抽象
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/11 16:25
 */
@RunWith(SpringRunner.class)
public abstract class BaseMapperTest<T extends BaseMapper> extends Assert {

    private T mapper;

    private SqlSession sqlSession;

    private static Executor executor;

    private static Configuration configuration;

    static {
        configuration = new Configuration();
        configuration.setCacheEnabled(false);
        configuration.setLazyLoadingEnabled(false);
        configuration.setAggressiveLazyLoading(true);
        configuration.setDefaultStatementTimeout(20);

        try {
            ResourcePropertySource propertySource = new ResourcePropertySource(new ClassPathResource("db.properties"));
            UnpooledDataSource dataSource = new UnpooledDataSource();
            dataSource.setDriver(propertySource.getProperty("driver-class-name").toString());
            dataSource.setUrl(propertySource.getProperty("url").toString());
            dataSource.setUsername(propertySource.getProperty("username").toString());
            dataSource.setPassword(propertySource.getProperty("password").toString());
            Transaction transaction = new JdbcTransaction(dataSource, TransactionIsolationLevel.READ_COMMITTED, true);
            executor = configuration.newExecutor(transaction);
        } catch (Exception e) {

        }
    }

    public BaseMapperTest() {
        String defaultMapperName = "mapping/" + this.getClass().getSimpleName().replace("Test", "") + ".xml";
        initMapper(defaultMapperName);
    }

    public BaseMapperTest(String mapperName) {
        initMapper(mapperName);
    }

    private void initMapper(String mapperName) {
        try {
            ClassPathResource mapperResource = new ClassPathResource(mapperName);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(
                    mapperResource.getInputStream(),
                    configuration,
                    mapperResource.toString(),
                    configuration.getSqlFragments());
            xmlMapperBuilder.parse();
            sqlSession = new DefaultSqlSession(configuration, executor, false);
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            MapperProxyFactory<T> mapperProxyFactory = new MapperProxyFactory<>((Class<T>) pt.getActualTypeArguments()[0]);
            mapper = mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {

        }

    }

    public T getMapper() {
        return mapper;
    }

    public abstract void testSelectByPrimaryKey();

}
