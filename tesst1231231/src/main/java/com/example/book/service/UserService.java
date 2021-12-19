package com.example.book.service;

import com.example.book.dto.UserDTO;
import com.example.book.entity.Account;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAll();
    public UserDTO getUserById(String username);
    public UserDTO insert(Account account);

    public void deleteUsername(String username);
}
