package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class CreateUserBindingModel {
    private String username;

    private String password;

    private String confirmPassword;

    public CreateUserBindingModel() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
