package com.application.SurveySystem.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "requests", schema = "public")
public class Requests {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;
	
    @ManyToOne
    @JsonBackReference
    private Users user;
    
    private String question;
    private String answer;
    
    @CreatedDate
    private Date created_at;
}
