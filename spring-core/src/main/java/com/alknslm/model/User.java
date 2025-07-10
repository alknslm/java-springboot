package com.alknslm.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor // tüm parametreleri içeren constructure
@NoArgsConstructor // parametresiz constructure
@ToString
public class User {
    private String firstName;
}
