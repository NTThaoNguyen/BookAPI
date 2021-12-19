package com.example.book.dto;

import com.example.book.entity.Account;
import com.example.book.entity.User;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String CMND;
    private String fullName;
    private String address;
    private String phone;
    private String email;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.CMND = user.getCMND();
        this.fullName = user.getFullName();
        this.address = user.getAddress();
        this.phone = user.getAddress();
        this.email = user.getEmail();
    }

    private User generateEntity() {
        User user = new User();
        Account account= new Account();
        account.setUser(user);
        account.setUsername(this.username);
        user.setAccount(account);
        user.setAddress(this.address);
        user.setCMND(this.CMND);
        user.setPhone(this.phone);
        user.setEmail(this.email);
        user.setFullName(this.fullName);
        return user;
    }
}
