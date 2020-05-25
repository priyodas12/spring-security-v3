package io.springlab.springsecurityv3.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum UserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            UserPermissions.COURSE_WRITE,
            UserPermissions.COURSE_READ,
            UserPermissions.STUDENT_READ,
            UserPermissions.STUDENT_WRITE
            )),
    ADMINTRINEE(Sets.newHashSet(
          UserPermissions.COURSE_READ,
          UserPermissions.STUDENT_READ
          ));

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }
}
