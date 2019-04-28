package com.springdata.demo.popj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Created by atben
 * 2018-01-24 14:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sboot")
public class Sboot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String test1;

    private String test2;

}
