package PROGRAM;

public class User {
    private String username;
    private String email;

    /**
     * Constructs a User object with the specified username and email.
     *
     * @param username The username of the user.
     * @param email    The email of the user.
     */
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * Returns the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The new username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The new email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
