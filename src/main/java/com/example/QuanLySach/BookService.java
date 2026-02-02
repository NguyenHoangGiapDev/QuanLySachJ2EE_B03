package com.example.QuanLySach;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>(Arrays.asList(
        new Book(1, "Spring Boot Cơ Bản", "Huy Cường"),
        new Book(2, "J2EE Nâng Cao", "Admin")
    ));

    public List<Book> getAllBooks() { return books; }
    public void addBook(Book book) {
        book.setId(books.size() + 1);
        books.add(book);
    }
    public Optional<Book> getBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }
    public void updateBook(Book updatedBook) {
        getBookById(updatedBook.getId()).ifPresent(b -> {
            b.setTitle(updatedBook.getTitle());
            b.setAuthor(updatedBook.getAuthor());
        });
    }
    public void deleteBook(int id) {books.removeIf(book -> book.getId() == id); }
}