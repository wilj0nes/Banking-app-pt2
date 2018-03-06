package com.revature.bank;

import java.io.Serializable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.Serializable;

public class CustomerCollection implements Serializable {

    private static final long serialVersionUID = -6250939837132126354L;
    private transient final Logger logger = Logger.getRootLogger();

    private int maxLength = 0;
    private int currentIndex = 0;
    private User[] users;

    public CustomerCollection(){
        users = new User[maxLength];
    }

    public void addUser(String name, String pass){
        User u = new User(name, pass);
        maxLength++;

        User[] tempArr = new User[maxLength];
        for(int i = 0; i < users.length; i++){
            tempArr[i] = users[i];
        }

        users = new User[maxLength];
        users = tempArr;
        users[maxLength - 1] = u;

//        logger.trace("New user: " + users[maxLength - 1].toString());
//        for(int i = 0; i < users.length; i++){
////            logger.fatal(users[i].getUserName());
//            if(users[i] == null && !stop){
//                users[i] = u;
//                System.out.println("New User --> " + users[i]);
//                currentIndex = i;
//                stop = true;
//            }
//        }
    }

    public User checkUserAndPass(String user, String pass){

        for(int i = 0; i < users.length; i++){

            if(users[i].getUserName().equals(user) && users[i].getPassWord().equals(pass)) {
                System.out.println("user found");
                return users[i];
            }
        }
        return null;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                str = str + "[" + users[i].getUserName() + ", " +
                        users[i].getPassWord() + ", " +
                        users[i].isApproved() + "]\n";
            }
        }

        return str;
    }

    public int getMaxLength() {
        return maxLength;
    }
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}


