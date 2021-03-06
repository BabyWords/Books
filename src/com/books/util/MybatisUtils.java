package com.books.util;

	import java.io.InputStream;
	import org.apache.ibatis.io.Resources;
	import org.apache.ibatis.session.SqlSession;
	import org.apache.ibatis.session.SqlSessionFactory;
	import org.apache.ibatis.session.SqlSessionFactoryBuilder;

	//import david.mybatis.model.CRUD_Enum;

	public class MybatisUtils {

	    private static final String CONFIG_PATH = "config/Mybatiscon.xml";
	    private static SqlSessionFactory factory=null;
	    /*
	     * 获取数据库访问链接
	     */
	    public static SqlSession getSqlSession() {
	        SqlSession session = null;
	        return session;
	    }
	    public static SqlSessionFactory getSqlSessionFactory(){
	    	 try {
		            InputStream stream = Resources.getResourceAsStream(CONFIG_PATH);
		            //可以根据配置的相应环境读取相应的数据库环境
		            // SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
		            // stream, "development"); 
		            factory = new SqlSessionFactoryBuilder()
		                    .build(stream);
		            //session = factory.openSession();
		        } catch (Exception e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
	    	return factory;
	    }
	    /*
	     * 获取数据库访问链接
	     */
	    public static void closeSession(SqlSession session) {
	        session.close();
	    }
	    
	    /*
	     * 返回操作记录消息
	     */
//	    public static void showMessages(CRUD_Enum type, int count) {
//	        switch (type) {
//	        case Add:
//	            System.out.println("添加了" + count + "条记录。");
//	            break;
//	        case Delete:
//	            System.out.println("删除了" + count + "条记录。");
//	            break;
//	        case Update:
//	            System.out.println("更新了" + count + "条记录。");
//	            break;
//	        case Query:
//	            System.out.println("匹配了" + count + "条记录。");
//	            break;
//	        case List:
//	            System.out.println("共有" + count + "条记录。");
//	            break;
//	        default:
//	            break;
//	        }
//	    }
//	}
}
