package com.it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * @author yyuanyan
 * @create 2019 - 07 - 25 - 9:33
 *
 * 程序的耦合
 */
public class JdbcDemo1 {
    private static final String url = "jdbc:mysql://localhost:3306/eesy";
    private static final String username = "root";
    private static final String password = "root";
    public static void main(String[]args) throws Exception{
//        你这种连接数据库的方法 我大一就不用了 我擦
        PreparedStatement pstm = null;
        Connection connection = null;
        ResultSet rs = null;
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver"); // 加载具体的驱动类
        //2.获取连接
        //String url;
        connection = DriverManager.getConnection(url, username, password);
        //3.获取操作数据库的预处理对象
        String sql = " select * from account";
        pstm = connection.prepareStatement(sql);
        //PreparedStatement pstm = conn.prepareStatement(sql:"select * from account");
        //4.执行SQL，得到结果集
        rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        connection.close();
   }

}
