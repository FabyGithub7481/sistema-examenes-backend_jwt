package com.sistema.examanes.sistema.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

import lombok.experimental.FieldDefaults;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "users")
public class UserT {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String userName;
  String password;
  String name;
  String lastName;
  String email;  String phone;
  Boolean enable = true;
  String profile;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userT")
  @JsonIgnore
  Set<UserRole> userRoles = new  HashSet<>();

}
