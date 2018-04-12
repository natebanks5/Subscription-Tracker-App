/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoovb
 */
public class User {
    private HashMap <String, String> accountLogin = new HashMap<>();
    private String username;
    private String password;
    private boolean authenticated = false;
    private ArrayList<User> userList = new ArrayList<User>(0);
    
    
    public User(String username, String password) {
        this.username = username; 
        this.password = password;
    }
    
    public User() {
    }
    public void addDefaultUsers() {
        /*getAccountLogin().put("user1", "password1");
        getAccountLogin().put("user2", "password2");
        getAccountLogin().put("user3", "password3");
        */
        User u1 = new User("user1", "password1");
        User u2 = new User("user2", "password2");
        User u3 = new User("user3", "password3");
        getUserList().add(u1);
        getUserList().add(u2);
        getUserList().add(u3);

    }
    
    public void authenticate(User user) {
            for (int i = 0; i<this.getUserList().size(); i++) {
                if (user.getUsername().equals(getUserList().get(i).getUsername()) && 
                        user.getPassword().equals(getUserList().get(i).getPassword())) {
                    setAuthenticated(true);
            }
        }
    }
    public void addToList(String username, String password) {
        User u1 = new User(username, password);
        this.getUserList().add(u1);
    }
    /**
     * @return the accountLogin
     */
    public Map <String, String> getAccountLogin() {
        return accountLogin;
    }

    /**
     * @param accountLogin the accountLogin to set
     */
    public void setAccountLogin(HashMap <String, String> accountLogin) {
        this.accountLogin = accountLogin;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the authenticated
     */
    public boolean isAuthenticated() {
        return authenticated;
    }

    /**
     * @param authenticated the authenticated to set
     */
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * @return the userList
     */
    public ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
