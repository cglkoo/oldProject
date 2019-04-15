package com.java.dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
 
public class Dao {
    //使用配置文件jdbc.properties获取数据库连接资源
	public static Connection getConnection(){
		Connection con = null;
		Properties prop = new Properties();
		InputStream is = Dao.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(is);
			String user=prop.getProperty("user");
			String password=prop.getProperty("password");
			String driver=prop.getProperty("driver");
			String jdbcUrl=prop.getProperty("jdbcUrl");
			Class.forName(driver);
			con=DriverManager.getConnection(jdbcUrl);
			 
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
 
	
	//关闭数据库连接资源
	public static void closeAll(ResultSet rest, PreparedStatement pst, Connection con){
		if(rest!=null){
			try {
				rest.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//查询只返回一个字段的通用方法；
	public static Object getObjectByProperty(String sql, Object...args){
		Object obj = null;
		Connection con= getConnection();
		PreparedStatement pst = null;
		ResultSet rest = null;
		try {
			pst=con.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				pst.setObject(i+1,args[i]);
			}
			rest=pst.executeQuery();
			if(rest.next()){
				obj=rest.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rest,pst,con);
		}
		return obj;
	}
	
	//一个什么都可以查询的方法:使用了泛型与反射机制；
	public static <T> List<T> getObjectsForList(Class clazz, String sql, Object ...args){
		List<T> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pst = null;
		ResultSet rest = null;
		T entity  = null;
		try {
			pst = con.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				pst.setObject(i+1,args[i]);
			}
			rest = pst.executeQuery();  //得到结果集；
			ResultSetMetaData rsmd = rest.getMetaData(); //得到ResultSetMetaData
			int count = rsmd.getColumnCount();          //得到查询得到所有列的数量；
			String [] colNames = new String [count];    //表中的字段数组；
			for(int i = 0 ; i<count; i++){
				colNames[i]=rsmd.getColumnLabel(i+1);  //数据库中表的字段名；
			}
			
			List<Map<String,Object>> values = new ArrayList<>();// values用来存储查询返回所有的数据记录；
			Map<String,Object> map = null;   //map用来存储查询返回一条记录；其中key表示字段名，value表示值；
			
			while(rest.next()){           //返回一条数据记录；
				map = new HashMap<>();
				for(int i=0;i<count;i++){  //获取一条数据记录的字段及字段的值；
					String key = colNames[i];
					Object val = rest.getObject(i+1);  //从1开始；
					map.put(key, val);   //已经找到了一条数据记录的字段名及其相应的值；
				}
				values.add(map);          //全部装入集合中；
			}
			//List中的Map一一取出来，然后转化为实体类的对象，再一一放进list中。
			if(values.size()>0){
				for(Map<String,Object> m : values){  //将List<Map<String,Object>>中的每一个map转化为每一个具体的实体对象；
					entity = (T) clazz.newInstance();  //通过反射获取以一个实体类的对象；
					for(Map.Entry<String, Object> entry : m.entrySet()){  //遍历每一个map中的键值对；
						
						String keys = entry.getKey();    //表中的字段名；转化为类中的属性；
						Object vals = entry.getValue();  //表中的字段值，转化为类中的属性值；
						//调用第三方的一个工具类；
						BeanUtils.setProperty(entity, keys, vals);
					}
					list.add(entity);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			closeAll(rest, pst, con);
		}
		return list;
	}
	//一个什么都可以增加、删除、修改的方法
	public static int addOrUpdateorDelete(String sql, Object ...args){
		 int num=0;
		 Connection con = getConnection();
		 PreparedStatement pst = null;
		 try {
			pst = con.prepareStatement(sql);
			for(int i=0;i<args.length; i++){
				pst.setObject(i+1,args[i]);
			}
			num=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(null, pst, con);
		}
		 return num;
	 }

	 public static void main(String[] args) {
		// Connection con = getConnection();
		// System.out.println(con);
	}
 


}
