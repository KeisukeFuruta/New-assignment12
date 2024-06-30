package org.example;

import java.util.List;

public class Library {

  public List<Book> bookList;

  public Library(List<Book> bookList) {
    this.bookList = bookList;
  }

  // 1: タイトル検索
  public List<Book> searchByTitle(String title) {
    List<Book> results = bookList.stream()
        .filter(book -> book.getTitle().equalsIgnoreCase(title))
        .toList();
    if (results.isEmpty()) {
      System.out.println("指定された書名の書籍は見つかりませんでした。");
    }
    return results;
  }

  // 2: 著者検索
  public List<Book> searchByAuthor(String author) {
    List<Book> results = bookList.stream()
        .filter(book -> book.getAuthor().equalsIgnoreCase(author))
        .toList();
    if (results.isEmpty()) {
      System.out.println("指定された著者の書籍は見つかりませんでした。");
    }
    return results;
  }

  // 3: 番号検索
  public List<Book> searchByNumber(int number) {
    List<Book> results = bookList.stream()
        .filter(book -> book.getNumber() == number)
        .toList();
    if (results.isEmpty()) {
      System.out.println("指定された番号の書籍は見つかりませんでした。");
    }
    return results;
  }
}

