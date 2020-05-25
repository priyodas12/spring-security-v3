package io.springlab.springsecurityv3.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities(){
       Set<SimpleGrantedAuthority> permissions
               =getPermissions()
               .stream()
               .map(p-> new SimpleGrantedAuthority(p.getPermission()))
               .collect(Collectors.toSet());
       permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

       return permissions;
    }
}
