package com.sistema.examanes.sistema.controller;

import com.sistema.examanes.sistema.entidades.Role;
import com.sistema.examanes.sistema.entidades.UserRole;
import com.sistema.examanes.sistema.entidades.UserT;
import com.sistema.examanes.sistema.service.IUserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

  @Autowired
  private IUserService iUserService;

  @PostMapping("/")
  public ResponseEntity<UserT> saveUser(@RequestBody UserT userT) throws Exception {
    userT.setProfile("default.png");
    userT.setPassword(new BCryptPasswordEncoder().encode(userT.getPassword()));;
    Role role = new Role();
    role.setRolId(2L);
    role.setNameRole("NORMAL");

    Set<UserRole> userRoles = new HashSet<>();
    UserRole userRole = new UserRole();
    userRole.setRole(role);
    userRole.setUserT(userT);
    userRoles.add(userRole);
    UserT newUserT=iUserService.saveUser(userT, userRoles);
    return ResponseEntity.ok(newUserT);

  }

  @GetMapping("/{userName}")
  public UserT getUserT(@PathVariable("userName") String userName) {
    return iUserService.getUser(userName);
  }

  @DeleteMapping("/{userId}")

  public void deleteUser(@PathVariable("userId") Long userId) {
    iUserService.deleteUser(userId);
  }

}
