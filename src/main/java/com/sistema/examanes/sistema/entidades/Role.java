package com.sistema.examanes.sistema.entidades;

import static lombok.AccessLevel.PRIVATE;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.experimental.FieldDefaults;


import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "roles")
public class Role {

  @Id
  Long rolId;
  String nameRole;


  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
  private Set<UserRole> userRoles = new HashSet<>();

}
