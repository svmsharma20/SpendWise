package com.bitbyteclub.SpendWise.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@NoArgsConstructor
public final class UserAuthority implements GrantedAuthority {

    @Id
    @Setter
    private String authority;

    public UserAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
