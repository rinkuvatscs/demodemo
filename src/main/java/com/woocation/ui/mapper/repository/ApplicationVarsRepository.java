package com.woocation.ui.mapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.woocation.ui.mapper.request.ApplicationVars;

public interface ApplicationVarsRepository extends MongoRepository<ApplicationVars, String> {

	ApplicationVars findByApplicationVarName(String applicationVarName);
}
