package cn.com.csii.mybatis.sqlsession;

public interface SqlSession {
    public <T> T getMapper(Class<T> daoInterfaceClass);
    void close();
}
