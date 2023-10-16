package com.mycompany.javafx_db_example;

public class LoginAuth
{
    private int UserID;
    private String UserName;
    private String PassWord;


    LoginAuth(int userID, String userName, String passWord)
    {
        UserID = userID;
        UserName = userName;
        PassWord = passWord;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
}
