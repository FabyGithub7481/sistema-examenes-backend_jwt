package com.sistema.examanes.sistema;

import com.sistema.examanes.sistema.entidades.Role;
import com.sistema.examanes.sistema.entidades.UserRole;
import com.sistema.examanes.sistema.entidades.UserT;
import com.sistema.examanes.sistema.service.IUserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {


  @Autowired
  private IUserService iUserService;

  public static void main(String[] args) {
    SpringApplication.run(SistemaExamenesBackendApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    /*try {
      UserT userT = new UserT();
      userT.setName("Leornado");
      userT.setLastName("Dicaprio");
      userT.setUserName("LeoDicaprio");
      userT.setPassword("12345");
      userT.setEmail("leo@gmail.com");
      userT.setPhone("0984785963");
      userT.setProfile("picture2.png");

      Role role = new Role();
      role.setRolId(1L);
      role.setNameRole("NORMAL");

      Set<UserRole> userRoles = new HashSet<>();
      UserRole userRole = new UserRole();
      userRole.setRole(role);
      userRole.setUserT(userT);
      userRoles.add(userRole);
      UserT userSave = iUserService.saveUser(userT, userRoles);
      System.out.println(userSave.getUserName());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }*/
  }
}
