package com.slorinc.myapplication.resources.entities;

/**
 * UserEO
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/11/2015
 */
public class UserEO {

    private Long id;
    private String name;
    private String email;

    public UserEO() {
    }

    public UserEO(Long id, String name, String email) {
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%d : %s [%s] \n", id, name, email);
    }
}
