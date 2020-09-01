package cn.com.csii.mybatis.sqlsession;

import cn.com.csii.mybatis.cfg.Configuration;
import cn.com.csii.mybatis.sqlsession.def.SqlSessionFactoryImpl;
import cn.com.csii.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new SqlSessionFactoryImpl(cfg);
    }
}
