package com.baojuan.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.baojuan.pojo.Flower;

@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = (InputStream) Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		/*session.selectList("a.b.selAll");
		session.close();*/
		/*三种查询方式
		 * selectList()返回值为List<resultType属性控制>集合
		 * 适合于查询结果需要遍历的需求
		 * selectOne()返回值Object
		 * 适合于返回结果只是变量或者一行数据
		 * selectMap()返回值为Map型
		 * 适合于需要在查询结果中通过某列的值取到这行数据的需求
		 * */
		
		
		//查询集合
		/*List<Flower> list=session.selectList("a.b.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}*/
		
		/*int count=session.selectOne("a.b.selectById");
		System.out.println(count);
		session.close();
		*/
		
		
		/*Flower p=session.selectOne("a.b.selectById",1);
		System.out.println(p);
		 * 使用#{}占位符
		 * 98 2019-03-27 18:15:46,997- ==>  Preparing: select * from flower where id=? 
		 139 2019-03-27 18:15:47,001- ==> Parameters:  
		 139 2019-03-27 18:15:47,036- <==      Total: 1 
*/
		
		
		/*
		 * 使用${}的情况
		 * Flower f=new Flower();
		f.setId(2);
		Flower p=session.selectOne("a.b.selectById",f);
		System.out.println(p);
		
		/*98 2019-03-27 18:15:46,997- ==>  Preparing: select * from flower where id=2  
				 139 2019-03-27 18:15:47,001- ==> Parameters:  
				 139 2019-03-27 18:15:47,036- <==      Total: 1 
		*/		

		
		/*使用map传值
		 * 98 2019-03-27 18:31:48,567- ==>  Preparing: select * from flower where id=? and name=?  
		 139 2019-03-27 18:31:48,571- ==> Parameters: 1(Integer), baihe(String) 
		 139 2019-03-27 18:31:48,607- <==      Total: 0 
				 
		Map<String, Object> map=new HashMap<>();
		map.put("id", 1);
		map.put("name", "baihe");
		Flower p=session.selectOne("a.b.selectById",map);
		System.out.println(p);
		session.close();
		*/
		
		//把数据库中的那个列的值当作map的key
		//Map<Object, Object> map=session.selectMap("a.b.c", "name");
		//System.out.println(map);
		/*{baihe=Flower [id=4, name=baihe, price=20, num=10],
		12233=Flower [id=5, name=12233, price=, num=2], 
		rose=Flower [id=1, name=rose, price=5, num=1], 
		测试名称=Flower [id=6, name=测试名称, price=18, num=6]}
		*/
		
		
		/*mybatis实现分页效果 */
		//一页显示几条
		/*int pageSize=2;
		//当前显示的第几页
		int pageNumber=2;
		int pageStart=pageSize*(pageNumber-1);
		Map<String,Object> map=new HashMap<>();
		map.put("pageSize", pageSize);
		map.put("pageStart", pageStart);
		List<Flower> list=session.selectList("a.b.page",map);
		System.out.println(list);
		session.close();*/
		
		
		/*数据库新增数据功能*/
		Flower f=new Flower();
		f.setName("juhua1");
		f.setPrice("30");
		f.setNum(2);
		int index=session.insert("a.b.ins",f);
		if(index>0) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
		
		f.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		try {
		int index1=session.insert("a.b.ins",f);
		if(index>0) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
	}
		}catch (Exception e) {
			session.rollback();
		}
		session.commit();
		session.close();
		System.out.println("执行结束");
	}
}
