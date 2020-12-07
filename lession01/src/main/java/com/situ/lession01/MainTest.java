package com.situ.lession01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.situ.lession01.dao.RoleDao;
import com.situ.lession01.role.pojo.Role;


public class MainTest {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("sqlSessionFactory: "+sqlSessionFactory);
		//SqlSessionFactory 得到数据库的一次会话 SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过session得到dao接口实例
		RoleDao roleDao =  sqlSession.getMapper(RoleDao.class);
		System.out.println("roleDao: "+roleDao);
		roleDao.insert(new Role(1, "test"));
		//执行提交
		sqlSession.commit();
		//数据库会话使用完毕后关闭
		sqlSession.close();
		
	}

}
