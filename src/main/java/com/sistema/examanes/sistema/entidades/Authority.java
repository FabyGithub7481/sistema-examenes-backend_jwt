package com.sistema.examanes.sistema.entidades;

import org.springframework.security.core.GrantedAuthority;

import static lombok.AccessLevel.PRIVATE;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Authority implements GrantedAuthority {

  String authority;

  @Override
  public String getAuthority() {
    return this.authority;
  }

}
