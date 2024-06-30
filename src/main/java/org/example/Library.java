package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Library {

  public List<Book> bookList;

  public Library(List<Book> bookList) {
    this.bookList = bookList;
  }

  // 1: タイトル検索
  public List<Book> searchByTitle(String title) {
    return bookList.stream()
        .filter(book -> book.getTitle().equalsIgnoreCase(title))
        .collect(Collectors.toList());
  }

  // 2: 著者検索
  public List<Book> searchByAuthor(String author) {
    return bookList.stream()
        .filter(book -> book.getAuthor().equalsIgnoreCase(author))
        .collect(Collectors.toList());
  }

  // 3: 番号検索
  public List<Book> searchByNumber(int number) {
    return bookList.stream()
        .filter(book -> book.getNumber() == number)
        .collect(Collectors.toList());
  }


}

