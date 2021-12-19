package com.example.book.controller;

import com.example.book.dto.AddAccountDTO;
import com.example.book.dto.UserDTO;
import com.example.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserById(username));
    }
    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody AddAccountDTO addAccountDTO) {
        return ResponseEntity.ok(userService.insert(addAccountDTO.generateEntity()));
    }
    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUsername(username);
    }
}
