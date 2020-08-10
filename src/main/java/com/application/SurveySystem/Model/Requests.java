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
    

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	private String question;
    private String answer;
    
    @CreatedDate
    private Date created_at;
    
    public Requests() {}
    
    public Requests(Users user, String question, String answer) {
  		super();
  		this.user = user;
  		this.question = question;
  		this.answer = answer;
  	}
}
