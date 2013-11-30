package com.silver.cms.security.entity;

import java.util.List;

/**
 *
 * @author Liaojian
 */
public class Role {
    private List<User> users;
    private List<Group> groups;
    private List<SecuritySubject> subjects;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }        
    
    public List<SecuritySubject> getSubjects() {
        return subjects;
    }
}
