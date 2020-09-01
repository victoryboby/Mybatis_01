package cn.com.csii.mybatis.io;

import java.io.InputStream;

public class Resources {
    public  static InputStream getResourceAsStream(String path){
        return new Resources().getClass().getClassLoader().getResourceAsStream(path);
    }
}
