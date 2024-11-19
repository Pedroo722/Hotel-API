package br.edu.ifpb.hotel.service;

import br.edu.ifpb.hotel.model.*;
import br.edu.ifpb.hotel.dtos.*;
import br.edu.ifpb.hotel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookResponseDTO> getBooksInformation() {
        return getAllBooksData()
                .stream()
                .map(this::convertToBookResponseDTO)
                .collect(Collectors.toList());
    }

    public List<BookResponseDTO> getBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author)
                .stream()
                .map(this::convertToBookResponseDTO)
                .collect(Collectors.toList());
    }

    public BookResponseDTO getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .map(this::convertToBookResponseDTO)
                .orElseThrow(() -> new RuntimeException("Book not found with title: " + title));
    }

    public List<BookResponseDTO> getBooksByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre)
                .stream()
                .map(this::convertToBookResponseDTO)
                .collect(Collectors.toList());
    }

    private List<Book> getAllBooksData() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            return Collections.emptyList();
        }
        return books;
    }

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book(null, bookRequestDTO.getTitle(), bookRequestDTO.getAuthor(), bookRequestDTO.getGenre(), bookRequestDTO.getUrl());
        Book savedBook = bookRepository.save(book);
        return convertToBookResponseDTO(savedBook);
    }    

    public BookResponseDTO updateBookByTitle(String title, BookRequestDTO bookRequestDTO) {
        Book bookToUpdate = bookRepository.findBookByTitle(title)
            .orElseThrow(() -> new RuntimeException("Book not found with title: " + title));

        bookToUpdate.setTitle(bookRequestDTO.getTitle());
        bookToUpdate.setAuthor(bookRequestDTO.getAuthor());
        bookToUpdate.setGenre(bookRequestDTO.getGenre());
        bookToUpdate.setUrl(bookRequestDTO.getUrl());

        Book updatedBook = bookRepository.save(bookToUpdate);
        return convertToBookResponseDTO(updatedBook);
    }

    public void deleteBookByTitle(String title) {
        Book bookToDelete = bookRepository.findBookByTitle(title)
            .orElseThrow(() -> new RuntimeException("Book not found with title: " + title));

        bookRepository.delete(bookToDelete);
    }   

    private BookResponseDTO convertToBookResponseDTO(Book bookInfo) {
        return new BookResponseDTO(
                bookInfo.getId(),
                bookInfo.getTitle(),
                bookInfo.getAuthor(),
                bookInfo.getGenre(),
                bookInfo.getUrl()
        );
    }
}