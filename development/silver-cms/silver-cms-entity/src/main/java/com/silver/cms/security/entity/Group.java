package com.silver.cms.security.entity;

import java.util.List;

/**
 *
 * @author Liaojian
 */
public interface Group {
    public List<User> getUsers();
    public List<Role> getRoles();
}
