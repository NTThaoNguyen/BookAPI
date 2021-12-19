package com.example.book.service.Impl;

import com.example.book.dto.UserDTO;
import com.example.book.entity.Account;
import com.example.book.entity.User;
import com.example.book.exception.DuplicateException;
import com.example.book.exception.NotFoundException;
import com.example.book.repository.AccountRepository;
import com.example.book.repository.UserRepository;
import com.example.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String username) {
        return new UserDTO(userRepository.findById(username).orElseThrow(()->new NotFoundException("Not found User with username: "+username)));

    }

    @Override
    public UserDTO insert(Account account) {
            User user = account.getUser();
            if(accountRepository.existsById(account.getUsername())) throw new DuplicateException("Username is exists");
            if(userRepository.existsByCMND(user.getCMND())) throw new DuplicateException("CMND is exists");
            if(userRepository.existsByEmail(user.getEmail())) throw new DuplicateException("Email is exists");
            if(userRepository.existsByPhone(user.getPhone())) throw new DuplicateException("Phone number is exists");
            account.setPassword(encoder.encode(account.getPassword()));
            return new UserDTO(accountRepository.save(account).getUser());

    }
    @Override
    public void deleteUsername(String username) {
        accountRepository.deleteById(username);
    }
}
