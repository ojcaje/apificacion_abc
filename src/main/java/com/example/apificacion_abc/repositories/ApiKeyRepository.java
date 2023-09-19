package com.example.apificacion_abc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.apificacion_abc.models.ApiKeyModel;

public interface ApiKeyRepository extends CrudRepository<ApiKeyModel, String> {
	
}
