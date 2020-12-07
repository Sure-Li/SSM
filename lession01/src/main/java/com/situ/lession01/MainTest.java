package com.situ.lession01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.situ.lession01.dao.RoleDao;
import com.situ.lession01.role.pojo.Role;
import com.situ.lession01.service.RoleService;
import com.situ.lession01.service.impl.RoleServiceImpl;
import com.situ.lession01.util.MyBatisUtil;


public class MainTest {

	public static void main1(String[] args) throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("sqlSessionFactory: "+sqlSessionFactory);
		//SqlSessionFactory 得到数据库的一次会话 SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过session得到dao接口实例
		RoleDao roleDao =  sqlSession.getMapper(RoleDao.class);
		System.out.println("roleDao: "+roleDao);
		/* roleDao.insert(new Role(1, "test")); */
		//一定要先获取到实例的所有内容
		Role role = roleDao.findOne(1L);
		System.out.println(role);
		role.setRoleName("testUpdate");
		role.setRoleType(0);
		roleDao.update(role);
		
		roleDao.delete(6L);
		
		
		System.out.println("roleDao.findAll()"+roleDao.findAll());
		//执行提交 增删改都要提交 从而让事务完成
		sqlSession.commit();
		//数据库会话使用完毕后关闭
		sqlSession.close();
		
	}
	public static void main(String[] args) {
		RoleDao roleDao = MyBatisUtil.getDao(RoleDao.class);
		System.out.println(roleDao.findOneByName("testUpdate", 1L));
	}

}
