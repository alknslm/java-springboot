package com.alknslm.handler;

import lombok.Data;

import java.util.Date;

@Data
public class Exception<E> {

    private String hostName;

    private String path;

    private Date createTime;

    private E message; // generic yapı için böyle oluşturuldu, String, int , map herşeyi alabilir bu şekilde
}
