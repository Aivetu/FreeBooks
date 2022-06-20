package com.example.freebooks;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {

    List<Books> findAll();

    Optional<Books> findById(int id);

    Books save(Books books);

   Books deleteById(int id);
}
