package business;

import dao.UserDao;
/*
* 窗口功能方法类
* */
public class User {
    //登录
    public boolean login(String username, String userpassword){
        UserDao userDao = new UserDao();
        //调用userDao中的方法，进行查询昵称是否存在
        pojo.User user = userDao.query(username);
        if(user!=null){//结果不为空，即有此账户
            if(userpassword.equals(user.getUserPassword())){//验证账户和密码
                return true;
            }
        }
        return false;
    }
    //注册
    public boolean register(String username, String userpassword){
        UserDao userDao = new UserDao();
        pojo.User user = new pojo.User();
        //将注册的昵称和密码暂存在用户对象user中
        user.setUserName(username);
        user.setUserPassword(userpassword);
        if(userDao.query(username)!=null){//查询
            System.out.println("注册中，查询到用户");
            return false;
        }
        else{
            userDao.insert(user);//在此处完成insert操作，并user的id完成自动获取
            System.out.println(user.getId());
            return true;
        }

    }
}
