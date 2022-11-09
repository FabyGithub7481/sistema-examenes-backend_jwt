package com.sistema.examanes.sistema.service.Impl;

import com.sistema.examanes.sistema.entidades.UserRole;
import com.sistema.examanes.sistema.entidades.UserT;
import com.sistema.examanes.sistema.repository.IRolRepository;
import com.sistema.examanes.sistema.repository.IUserRepository;
import com.sistema.examanes.sistema.service.IUserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository iUserRepository;

  @Autowired
  private IRolRepository iRolRepository;

  @Override
  public UserT saveUser(UserT userT, Set<UserRole> userRoles) throws Exception {
    UserT localUserT = iUserRepository.findByUserName(userT.getUserName());
    if (localUserT != null) {
      System.out.println("El usuario ya existe");
      throw new Exception("El usuario ya esta presente");
    } else {
      for (UserRole userRole : userRoles) {
        iRolRepository.save(userRole.getRole());
      }
      userT.getUserRoles().addAll(userRoles);
      localUserT = iUserRepository.save(userT);
    }
    return localUserT;
  }

  @Override
  public UserT getUser(String userName) {
    return iUserRepository.findByUserName(userName);
  }

  @Override
  public void deleteUser(Long idUserT) {
   iUserRepository.deleteById(idUserT);
  }
}
