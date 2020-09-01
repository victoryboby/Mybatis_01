package cn.com.csii.mybatis.sqlsession.def;

import cn.com.csii.mybatis.cfg.Configuration;
import cn.com.csii.mybatis.sqlsession.SqlSession;
import cn.com.csii.mybatis.sqlsession.proxy.MapperProxy;
import cn.com.csii.mybatis.utils.GetDatasoure;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class SqlSessionImpl implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        this.conn = GetDatasoure.getConnection(cfg);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {

        return  (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),conn));
    }

    public void close() {
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
