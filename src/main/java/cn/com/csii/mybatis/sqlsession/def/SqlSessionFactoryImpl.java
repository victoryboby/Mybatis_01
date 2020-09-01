package cn.com.csii.mybatis.sqlsession.def;

import cn.com.csii.mybatis.cfg.Configuration;
import cn.com.csii.mybatis.sqlsession.SqlSession;
import cn.com.csii.mybatis.sqlsession.SqlSessionFactory;

public class SqlSessionFactoryImpl implements SqlSessionFactory {
    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
