package com.sistema.examanes.sistema.entidades;

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
public class JwtResponse {

  String token;


}
