package com.sistema.examanes.sistema.entidades;


import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.experimental.FieldDefaults;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Entity
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long userRolId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_t_id")
  UserT userT;
  @ManyToOne
  @JoinColumn(name = "role_rol_id")
  Role role;


}
