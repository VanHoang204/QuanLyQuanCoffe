/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dell
 */
public class Model_Login {
    private String Username;
    private String password;
    private String role;

    public Model_Login() {
    }

    public Model_Login(String Username, String password) {
        this.Username = Username;
        this.password = password;
    }

    public Model_Login(String role) {
        this.role = role;
    }
    
    
    

    public Model_Login(String Usernam, String password, String role) {
        this.Username = Username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsernam(String Usernam) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
