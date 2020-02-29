package com.bstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bstore.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

	
}
