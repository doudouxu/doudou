package com.qingke.utils;

import java.io.InputStream;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {
   private static SessionUtils sessionUtils;
   private SessionUtils(){}
   private static SqlSessionFactory sqlSession;
   static{
	   String resource="myBatis_conf.xml";
	   InputStream is=SessionUtils.class.getClassLoader().getResourceAsStream(resource);
	   sqlSession=new SqlSessionFactoryBuilder().build(is);
   }
   
   public static SessionUtils getInstance(){
	   if(sessionUtils==null){
		   sessionUtils=new SessionUtils();
	   }
	   return sessionUtils;
   }
   
   public static SqlSessionFactory getSqlSession(){
	   return sqlSession;
   }
   
}
