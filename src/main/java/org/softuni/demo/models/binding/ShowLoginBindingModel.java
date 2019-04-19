package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class ShowLoginBindingModel {
    private String username;

    private String password;

    public ShowLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
