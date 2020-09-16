public class DB {
    //数据库连接
    private Connection connection = null;
    //sql语句
    private String sql = null;
    //准备执行
    private PreparedStatement prepare;
    //执行结果
    private ResultSet rs =null;

    //获取私有变量sql
    public String getSql(){
        return sql;
    }
    //构造函数
    public DB(){
        try {
            //打开连接
            //1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //设置连接字符串，默认端口为3306
            String url = "jdbc:mysql://localhost:3306/javafx_db?serverTimezone=GMT%2B8";
            /*参数分别为
            连接字符串
            用户名
            密码
            * */
            try {
                Connection connection = DriverManager.getConnection(url, "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //筛选
    public boolean select_operation(String username, String password){
        try {
            prepare = connection.prepareStatement(sql);
            prepare.setString(1, username);
            prepare.setString(2, password);
            //执行筛选操作
            prepare.executeQuery();
            //通过筛选记录是否为空 判断是否找到想要的结果
            rs = prepare.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
                if(prepare!=null){
                    prepare.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false;
    }
    //查询欢乐豆
    public int select_operation(String id){
        try {
            prepare = connection.prepareStatement(sql);
            prepare.setString(1, id);
            //执行筛选操作
            prepare.executeQuery();
            //通过筛选记录是否为空 判断是否找到想要的结果
            rs = prepare.executeQuery();
            int coin = rs.findColumn("id");
            return coin;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
                if(prepare!=null){
                    prepare.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    //插入用户信息
    public boolean insert_operation(String username, String password, String sex){
        try {
            prepare = connection.prepareStatement(sql);
            prepare.setString(1, username);
            prepare.setString(2, password);
            prepare.setInt(3, Integer.parseInt(sex));
            /*执行插入，并判断是否成功
            *executeUpdate()返回更新记录的数目，未插入成功，更新记录为0
            *
             */
            int result = prepare.executeUpdate();
            if(result>0){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(prepare!=null){
                    prepare.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    //更新欢乐豆
    public boolean update_operation(String coin){
        try {
            prepare = connection.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(coin));
            /*执行插入，并判断是否成功
             *executeUpdate()返回更新记录的数目，未插入成功，更新记录为0
             *
             */
            int result = prepare.executeUpdate();
            if(result>0){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(prepare!=null){
                    prepare.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
