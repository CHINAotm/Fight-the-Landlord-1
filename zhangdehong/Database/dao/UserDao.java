package dao;

import pojo.User;
import utils.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
/*
* 对sql语句进行拼接处理，并调用对应方法
* */
public class UserDao {

    //通过昵称查询
    public User query(String username){
        String sql= "select * from User where username = '"+username+"'";
        ResultSet rs = DBHelper.query(sql);
        User user = null;
        try {
            if(rs!=null&&rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setCoin(rs.getInt("id"));
                user.setRoom(rs.getInt("room"));
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    //通过id查询
    public User query(int id){
        String sql= "select * from User where id = '"+id+"'";
        ResultSet rs = DBHelper.query(sql);
        User user = null;
        try {
            if(rs!=null&&rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setCoin(rs.getInt("id"));
                user.setRoom(rs.getInt("room"));
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    //插入用户
    public void insert(User user){
        String sql = "insert into user(username, userpassword, coin, room) values('" + user.getUserName() + "','" + user.getUserPassword() + "','" + user.getCoin()  + "','" + user.getRoom()+ "')";
        if(DBHelper.execute(sql)>0){
            System.out.println("插入成功");
            sql= "select * from User where username = '"+user.getUserName()+"'";
            ResultSet rs = DBHelper.query(sql);
            try {
                if(rs!=null&&rs.next()){
                    user.setId(rs.getInt("id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("插入失败");
        }
    }
    //更新欢乐豆和房间
    public void update(User user){
        String sql = "update user set coin = '" + user.getCoin() + "',room = '"+user.getRoom()+"' where id = '" + user.getId() + "')";
        DBHelper.execute(sql);
    }
}
