package cn.com.csii.mybatis.sqlsession.proxy;

import cn.com.csii.mybatis.cfg.Mapper;
import cn.com.csii.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler  {
    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodname = method.getName();
        String classname = method.getDeclaringClass().getName();
        String key= classname + "." + methodname;
        Mapper mapper = mappers.get(key);
        if (mapper==null){
            throw new IllegalArgumentException("输入的参数有误");
        }
        return new Executor().selectList(mapper,connection);
    }
}
