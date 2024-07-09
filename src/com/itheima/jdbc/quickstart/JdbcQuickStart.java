package com.itheima.jdbc.quickstart;

import org.junit.Test;

import java.sql.*;

public class JdbcQuickStart {

    @Test
    public void quickStartTest() throws ClassNotFoundException, SQLException {
        //1、注册驱动 （确认要使用哪个数据库）
        Class.forName("com.mysql.jdbc.Driver"); //加载Driver类

        //2、连接数据库 （获取到一个数据库连接对象）
        String url = "jdbc:mysql://127.0.0.1:3306/db5";
        //String url ="jdbc:mysql://127.0.0.1:3306/db5?useUnicode=true&characterEncoding=utf8";//解决中文乱码
        Connection conn = DriverManager.getConnection(url, "root", "");
        //Connection 获取执行SQL的对象，事务管理


        //3、编写SQL语句
        String sql = "select id,username AS name,password from user";

        //4、把SQL语句发送给数据库 （数据库执行SQL代码，并返回执行结果）
        Statement stmt = conn.createStatement();//基于数据库连接对象，创建一个操作数据库的对象
        ResultSet rs = stmt.executeQuery(sql);//把sql代码发给数据库

        //5、处理SQL的执行结果
        while (rs != null && rs.next()) {
            System.out.print(rs.getInt("id") + "\t");
            System.out.print(rs.getString("name") + "\t");
            System.out.println(rs.getString("password") + "\t");
            System.out.println("=======================================");
        }

        //6、释放资源（断开和数据库的连接）
        rs.close();
        stmt.close();
        conn.close();
    }

}
