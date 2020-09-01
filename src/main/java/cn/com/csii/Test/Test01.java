package cn.com.csii.Test;

import cn.com.csii.bean.Account;
import cn.com.csii.dao.AccountDao;

import cn.com.csii.mybatis.io.Resources;
import cn.com.csii.mybatis.sqlsession.SqlSession;
import cn.com.csii.mybatis.sqlsession.SqlSessionFactory;
import cn.com.csii.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/*
* class Resources {
* class SqlSessionFactoryBuilder {
* interface SqlSessionFactory
* interface SqlSession
*   getMapper
* */
public class Test01 {
    @Test
    public void findAll() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //使用工厂代理类来创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建工厂
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //使用sqlsession代理创建accountdao
        AccountDao ac = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = ac.findall();
        for (Account a : accounts){
            System.out.println(a);
        }
    }
}
