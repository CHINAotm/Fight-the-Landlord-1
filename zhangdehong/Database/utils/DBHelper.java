package utils;

import java.sql.*;
/*
* 进行数据库连接操作支持的
* */
public class DBHelper {
    private static String hostIP;//IP地址
    private static String port;//端口
    private static String dbName;//数据库名
    private static String dbUser;//用户名
    private static String password;//数据库密码

    public static void setHostIP(String hostIP) {
        DBHelper.hostIP = hostIP;
    }

    public static void setPort(String port) {
        DBHelper.port = port;
    }

    public static void setDbName(String dbName) {
        DBHelper.dbName = dbName;
    }

    public static void setDbUser(String dbUser) {
        DBHelper.dbUser = dbUser;
    }

    public static void setPassword(String password) {
        DBHelper.password = password;
    }
    //默认构造函数
    public DBHelper(){
        hostIP = "localhost";
        port = "3306";
        dbName = "doudizhu";
        dbUser = "root";
        password = "root";
    }
    //得到连接（内部使用，private）
    private static Connection getConnection(){
        try {
            /*
             * cj
             * */
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String dbUrl = "jdbc:mysql://" + hostIP + ":" + port + "/" + dbName;
        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //单纯执行select sql语句
    public static ResultSet query(String sql){
        //调用类内部方法
        Connection connection = getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //执行其他sql语句
    public static int execute(String sql){
        //调用类内部方法
        Connection connection = getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
