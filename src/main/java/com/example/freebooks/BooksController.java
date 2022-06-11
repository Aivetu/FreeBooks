package com.example.freebooks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Books getBookById(@PathVariable int id) throws Exception {
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

    public ResponseEntity<String> getBookById(){
        return new ResponseEntity<>("Id doesn't exist", HttpStatus.NOT_FOUND);
    }

}
