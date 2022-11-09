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

 /* @ManyToOne
  @JoinColumn(name = "role_rol_id")
  private Role role;

  @ManyToOne
  @JoinColumn(name = "user_t_id")
  private UserT userT;

  public UserT getUserT() {
    return userT;
  }

  public void setUserT(UserT userT) {
    this.userT = userT;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
*/

}
