package com.mandiri.jpatokonyadia.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Author {

    private String name;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;

    public Author(String name, Date bithDate) {
        this.name = name;
        this.birthDate = bithDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", bithDate=" + birthDate +
                '}';
    }
}
