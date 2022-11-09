package com.sistema.examanes.sistema.service;

import com.sistema.examanes.sistema.entidades.UserRole;
import com.sistema.examanes.sistema.entidades.UserT;
import java.util.Set;

public interface IUserService {

  public UserT saveUser(UserT userT, Set<UserRole> userRoles) throws Exception;
  public UserT getUser(String userName);
  public void deleteUser(Long idUserT);


}
