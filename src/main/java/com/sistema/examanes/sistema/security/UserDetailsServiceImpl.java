package com.sistema.examanes.sistema.security;

import com.sistema.examanes.sistema.entidades.UserT;
import com.sistema.examanes.sistema.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


  @Autowired
  private IUserRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserT usuario = usuarioRepository.findOneByEmail(email)
        .orElseThrow(
            () -> new UsernameNotFoundException("El usuario con email " + email + "no existe"));
    // TODO Auto-generated method
    return new UserDetailsImpl(usuario);
  }
  public UserT loadUserByUsernameUser(String email) throws UsernameNotFoundException {
    UserT usuario = usuarioRepository.findOneByEmail(email)
        .orElseThrow(
            () -> new UsernameNotFoundException("El usuario con email " + email + "no existe"));
    // TODO Auto-generated method
    return  usuario;
  }
/*@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  UserT usuario = this.usuarioRepository.findByUserName(username);
  if(usuario == null){
    throw new UsernameNotFoundException("Usuario no encontrado");
  }
  return (UserDetails) usuario;
}*/
}
