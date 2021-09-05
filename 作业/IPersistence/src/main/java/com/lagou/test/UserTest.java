package com.lagou.test;

import com.lagou.mapper.UserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    private UserMapper userMapper;


    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void queryUser(){
        User user = this.userMapper.selectByPrimaryKey(1);
        System.out.println(user);
        List<User> allUser = userMapper.findAllUser();
        System.out.println(allUser);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("sunjianhua");
        user.setPassword("245634");
        user.setBirthday("1995-10-26");

        userMapper.updateByPrimaryKey(user);

    }

    @Test
    public void deleteUserById(){
        userMapper.deleteByPrimaryKey(4);
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setId(4);
        user.setUsername("sunji333anhua");
        user.setPassword("245634");
        user.setBirthday("1995-10-26");
        int insert = userMapper.insert(user);
    }



}
