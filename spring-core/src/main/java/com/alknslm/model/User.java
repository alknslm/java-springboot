package com.alknslm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // tüm parametreleri içeren constructure
@NoArgsConstructor // parametresiz constructure
public class User {
    private String firstName;
}
