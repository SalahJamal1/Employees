package com.app.employee.auth;

import com.app.employee.user.ROLE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegister {
    private String firstName;
    private String lastName;
    private String email;
    private ROLE role;
    private String password;

}
