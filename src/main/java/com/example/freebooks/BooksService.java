package com.example.freebooks;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BooksRepo booksRepo;

    public List<Books> retrieveAllBooks() {
        return booksRepo.findAll();
    }

    public Books retrieveBookById(int id) throws Exception {
        Optional<Books> optional = booksRepo.findById(id);
        if (optional.isPresent())
            return optional.get();
        else throw new IllegalStateException("Id doesn't exist");


    }

    public Books createNewBook(Books books) {
        return booksRepo.save(books);
    }

    public Books deleteBookById(int id) {
        Optional<Books> optional = booksRepo.findById(id);
        if (optional.isPresent())
            optional.get();
        else throw new IllegalStateException("Id doesn't exist");
        return booksRepo.deleteById(id);

    }

    public Books updateBookInfo(Books books) {
        Optional<Books> books1 = booksRepo.findById(books.getId());
        if (books1.isPresent())
            books1.get();
        else throw new IllegalStateException("Id does not exist");

        Books newBook = new Books();
        newBook.setAuthor(books.getAuthor());
        newBook.setName(books.getName());
        return booksRepo.save(books);

    }
}


