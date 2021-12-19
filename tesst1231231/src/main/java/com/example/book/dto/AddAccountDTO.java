package com.example.book.dto;

import com.example.book.entity.Account;
import com.example.book.entity.Role;
import com.example.book.entity.RoleName;
import com.example.book.entity.User;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddAccountDTO {
    private String username;
    private String password;
    @NotBlank(message = "CMND must be not blank")
    @Column(unique = true)
    @Size(min = 9, max = 12)
    private String CMND;
    @NotBlank(message = "Full name must be not blank")
    @Size(min = 1, max = 255)
    private String fullName;
    @NotBlank(message = "Address must be not blank")
    @Size(max = 255)
    private String address;
    @Size(min = 10, max = 10,message = "Phone number length must be 10")
    private String phone;
    @NotBlank(message = "Email must be not blank")
    @Email(message = "Email needs to be in the correct format")
    private String email;
    public Account generateEntity() {
        Account account = new Account();
        Role role = new Role();
        account.setUsername(this.username);
        account.setPassword(this.password);
        role.setId(2L);
        role.setName(RoleName.ROLE_USER);
        account.setRole(role);
        User user= new User();
        user.setAddress(this.address);
        user.setCMND(this.CMND);
        user.setPhone(this.phone);
        user.setEmail(this.email);
        user.setFullName(this.fullName);
        user.setAccount(account);
        account.setUser(user);
        return account;
    }
}
