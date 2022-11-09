package com.sistema.examanes.sistema.controller;

import com.sistema.examanes.sistema.entidades.UserT;
import com.sistema.examanes.sistema.security.AuthCredentiales;
import com.sistema.examanes.sistema.security.TokenUtils;
import com.sistema.examanes.sistema.security.UserDetailsImpl;
import com.sistema.examanes.sistema.security.UserDetailsServiceImpl;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

//    @Autowired
//    private TokenUtils jwtUtils;

    /*@PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody AuthCredentiales jwtRequest) throws Exception {
        try{
            autenticar(jwtRequest.getEmail(),jwtRequest.getPassword());
        }catch (Exception exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }
        //UserDetailsImpl userDetails= (UserDetailsImpl)authResult.getPrincipal();

        //*UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getEmail());
        String token= TokenUtils.createToken(userDetails.getPassword(),userDetails.getUsername());
        return ResponseEntity.ok(token);
    }*/

    private void autenticar(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public UserT obtenerUsuarioActual(Principal principal){
        return (UserT) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
