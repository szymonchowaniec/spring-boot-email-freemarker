package com.javatechie.email.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
public class Metting {

    @Id
    @GeneratedValue
    public long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate mettingDate;


}
