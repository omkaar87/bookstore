package com.bstore.config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.bstore.entity.Book;
import com.bstore.entity.BookCategory;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	@Autowired
	private EntityManager entityManager;
	
	//by default spring-data-rest prevents exposing id of entities
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	
		//this can expose id's of particular class
		config.exposeIdsFor(Book.class,BookCategory.class);
		
		//it can expose all entities id whenever you create new Entity class
		/*
		 * config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
		 * .map(Type::getJavaType) .toArray(Class[]::new));
		 */
		
	}
}
