package com.alknslm.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
    /** Bu dataclassların kullanıldığı yerde @Valid anotasyonu kullanılması gerekiyor.*/

    @NotEmpty(message = "Firstname alanı boş bırakılamaz")
    @Min(value = 3, message = "Firstname Minimum 3 karakter olmalı")
    @Max(value = 10, message = "Firstname Maksimim 10 karakter olmalı")
    private String firstName;

    @Size(min = 3, max = 30)
    private String lastName;

    private Date birthOfDate;

    @Email(message = "Email formatında giriniz")
    private String email;

    @Size(min = 11, max = 11, message = "TCKN 11 haneli olmalı")
    @NotEmpty(message = "TCKN alanı boş geçilemez")
    private String tckn;
}
