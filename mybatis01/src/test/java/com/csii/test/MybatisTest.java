package com.csii.test;

import com.csii.dao.IUserDao;
import com.csii.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


public class MybatisTest {
    public static void main(String[] args) throws Exception{

        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        SqlSession session=factory.openSession();
        //创建Dao接口的代理对象
        IUserDao userDao=session.getMapper(IUserDao.class);
        List<User> users=userDao.queryAll();
        for(User user : users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
