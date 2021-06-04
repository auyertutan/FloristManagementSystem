package Model;

public class Authentication {
    private Boolean isAuthenticated = false;
    private String username = "";

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void logout() {
        this.setUsername("");
        this.setAuthenticated(false);
    }

    public void login(String username) {
        this.setUsername(username);
        this.setAuthenticated(true);
    }
}
