package com.silver.cms.security.entity;

import java.util.List;

/**
 *
 * @author Liaojian
 */
public class User implements SecuritySubject{
    private List<Group> groups;
    private List<Role> roles;
    
    public List<Group> getGroups() {
        return groups;
    }
    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public SecuritySubjectType getType() {
        return SecuritySubjectType.USER;
    }
    
    
}
