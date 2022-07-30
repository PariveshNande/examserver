package com.exam.model;

import javax.persistence.*;

@Entity(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    /**
     * UserRole will have single user (one to many relationship)
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /**
     * UserRole will have single role (one to many relationship)
     */

    @ManyToOne
    private Role role;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}