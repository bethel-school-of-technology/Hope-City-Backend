package com.codebrew.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attending{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    
}