package net.stuha.security;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User data
 */
@Entity(name = "users")
public class User {

    @Id
    private String id;

    private String name;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
