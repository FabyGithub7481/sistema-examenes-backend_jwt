package com.sistema.examanes.sistema.repository;

import com.sistema.examanes.sistema.entidades.UserT;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserRepository extends JpaRepository<UserT,Long>,
    JpaSpecificationExecutor<UserT> {

  public UserT findByUserName(String userName);
  Optional<UserT> findOneByEmail(String email);
}
