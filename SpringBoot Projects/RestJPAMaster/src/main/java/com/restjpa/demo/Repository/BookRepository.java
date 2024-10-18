package com.restjpa.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restjpa.demo.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
