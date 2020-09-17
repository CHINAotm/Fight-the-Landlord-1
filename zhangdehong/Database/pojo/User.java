package pojo;

public class User {
    private int id;
    private String username;
    private String userpassword;
    private int coin;
    private int room;

    public void User(){
        id =0 ;
        username = null;
        userpassword = null;
        coin = 0;
        room = -1;
    }
    public String getUserName(){
        return username;
    }
    public void setUserName(String username){
        this.username=username;
    }
    public String getUserPassword(){
        return  userpassword;
    }
    public void setUserPassword(String userpassword){
        this.userpassword=userpassword;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getCoin() {
        return coin;
    }
    public void setCoin(int coin) {
        this.coin = coin;
    }
    public int getRoom(){
        return  room;
    }
    public void setRoom(int room){
        this.room = room;
    }
}
