package com.hzxy.test;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.hzxy.entity.User;
import com.hzxy.tool.MyDBUtils;
public class MySqlTest {
	public static void main(String[] args) throws Exception {
		//add() ;
		//update();
		//delete();
		//select1();
		//select2();
		//select3();
		select4();
		//select5() ;
	}
//测试：向数据表user插入一条数据
public static void add() throws Exception{
		
	
	// ?,就是sql语句占位符
	String sql = "insert into user(name,age) values(?,?)";
	//执行插入操作
	//update(sql, params)  就是执行数据库增删改sql语句操作的方法
	//	sql,增删改sql语句
	//	params,sql语句中的占位符
	MyDBUtils.runner.update(sql, "王五",20);
	
	System.out.println("sql执行成功了");
	}
	
public static void update() throws Exception{
		
		//需求：将王五用户的年龄修改为30岁
		// ?,就是sql语句占位符
		String sql = "update user set age=? where name=?";
		
		MyDBUtils.runner.update(sql, 30,"王五");
		
		System.out.println("sql执行成功了");
	}
/**
 * 删除操作
 * @throws Exception
 */
public static void delete() throws Exception{
	
	//需求：将王五删除


	// ?,就是sql语句占位符
	String sql = "delete from user where name=?";
	
	MyDBUtils.runner.update(sql, "王五");
	
	System.out.println("sql执行成功了");
}

/**
 * 例4使用java查询user表一条数据
 * 要求，查询到的数据使用User类对象封装起来
 * @throws Exception 
 */
public static void select1() throws Exception{
	//需求：查询id为1的user数据
	String sql ="select * from user where id=?";
	//查询返回一个User类对象
	//runner.query(sql, rsh, params)	执行select语句的方法
	//	sql，就是要执行的sql语句
	//	rsh，封装查询结果的处理器对象
	//		BeanHandler,封装返回指定的一个表对象数据
	//		BeanListHandler，封装返回指定一个表的多条数据的返回List集合
	//		MapHandler，封装返回指定单表或多表一条记录多个字段的数据返回Map集合
	//		MapListHandler,封装返回单表或多表多条条记录多个字段的数据返回List<Map>集合
	//		ScalarHandler,返回查询数据结果集中第一行中第一列，返回一个值
	//	params，可变参数，就是参数个数不固定，参数个数需要几个就传几个
	User user = MyDBUtils.runner.query(sql, new BeanHandler<User>(User.class), 2);
	System.out.println(user);
}


/**
 * 5.3.6	案例5使用java查询user表所有数据使用List<User>封装
 */
public static void select2() throws Exception{
	//需求：查询id为1的user数据
	String sql ="select * from user";
	//查询返回一个User类对象
	
	List<User> users = MyDBUtils.runner.query(sql, new BeanListHandler<User>(User.class));
	System.out.println(users);
}

/**
 * 查询李四的操作记录id为3的信息（name,age,content,operatetime）
 */
public static void select3() throws Exception{
	//需求：查询id为1的user数据
	String sql ="SELECT ur.name,ur.age,re.content,re.operaterime FROM USER ur,"
			+ "user_remarke re WHERE ur.id=re.userid AND ur.name=? AND re.id=?";
	
	Map map = MyDBUtils.runner.query(sql, new MapHandler(),"李四",3);
	
	System.out.println("name="+map.get("name"));
	System.out.println("age="+map.get("age"));
	System.out.println("content="+map.get("content"));
	System.out.println("operatetime="+map.get("operaterime"));

}


/**
 * 5.3.8	案例7使用java查询多表中多条数据
 */
public static void select4() throws Exception{
	
	String sql ="SELECT ur.name,ur.age,re.content,re.operaterime FROM USER ur,"
			+ "user_remarke re WHERE ur.id=re.userid";
	
	
	List<Map<String,Object>> maps = MyDBUtils.runner.query(sql, new MapListHandler());
	for (Map<String, Object> map : maps) {
		System.out.println("name="+map.get("name"));
		System.out.println("age="+map.get("age"));
		System.out.println("content="+map.get("content"));
		System.out.println("operaterime="+map.get("operaterime"));
	}
}



/**
 * 5.3.9	案例8使用java查询表结果集中第一行第一列
 */
public static void select5() throws Exception{
	String sql ="select count(*),max(name) from user";
	Long count = MyDBUtils.runner.query(sql, new ScalarHandler<Long>(1));
	System.out.println("用户表的记录数一共"+count.intValue()+"条");
}




}
