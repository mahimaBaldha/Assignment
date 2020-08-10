package com.application.SurveySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.SurveySystem.Model.Requests;

@Repository
public interface RequestRepository extends JpaRepository<Requests, Integer>{

}
