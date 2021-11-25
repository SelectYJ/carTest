package com.service;

import com.bean.sUser;
import com.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SetUpConn {
    InputStream is = null;
    SqlSession sqlSession = null;
    public UserMapper returnUserMapper(){
        SqlSessionFactory factory;
        try {
            Map<String, Object> data = new HashMap();
            String resource = "mybatis-config.xml";
            is = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void commitCloseSqlSession(){
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
    public void inputStreamSqlSession(){
        if(is!=null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
