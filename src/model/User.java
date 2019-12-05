package model;

public class User {
    private int ID;
    private int ClientID;
    private String UserName;
    private String Password;
    private int Role;
    
    public User() {

    }
    public User(int clientID, String userName, String password, int role) {
        ClientID = clientID;
        UserName = userName;
        Password = password;
        Role = role;
    }
    public User(int iD, int clientID, String userName, String password, int role) {
        ID = iD;
        ClientID = clientID;
        UserName = userName;
        Password = password;
        Role = role;
    }
    public int getID() {
            return ID;
    }
    public void setID(int iD) {
            ID = iD;
    }
    public int getClientID() {
            return ClientID;
    }
    public void setClientID(int clientID) {
            ClientID = clientID;
    }
    public String getUserName() {
            return UserName;
    }
    public void setUserName(String userName) {
            UserName = userName;
    }
    public String getPassword() {
            return Password;
    }
    public void setPassword(String password) {
            Password = password;
    }
    public int getRole() {
            return Role;
    }
    public void setRole(int role) {
            Role = role;
    }

	
}
