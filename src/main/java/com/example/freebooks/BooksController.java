package com.example.freebooks;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    BooksService booksService;


    @GetMapping("")
    public List<Books> getAllBooks(){
        return booksService.retrieveAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable int id)  {
        return booksService.retrieveBookById(id);
    }

    @PostMapping("")
    public Books createStudent(@RequestBody Books books){
        return booksService.createNewBook(books);
    }

    @PutMapping("")
    public Books updateBook(@RequestBody Books books){
        return  booksService.updateBookInfo( books);
    }

    @DeleteMapping("/{id}")
    public Books deleteBooks(@PathVariable int id){
        return booksService.deleteBookById(id);
    }



}
