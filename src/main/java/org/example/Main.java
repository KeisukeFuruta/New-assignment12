package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 図書管理システムを作る
    // 書籍（Book）を管理する情報（タイトル、著者、番号）を持つオブジェクト（クラス）を作って、そこに情報を格納してください。
    // 図書館(Library)みたいなものを作って、そこにBookをListで持つようなものを保持する
    // mainメソッドからこのLibraryクラスに対して検索ができるようにする。Libraryクラスは書籍検索の機能を持つ。
    // タイトル検索、著者検索、番号検索メソッドをLibraryに持たせる。
    // それをmainメソッドから実行して、実行結果をコンソールに出力する。

    // 書籍を追加
    Book book1 = new Book("ブランディングの科学", "バイロン・シャープ", 1);
    Book book2 = new Book("プロになるJava", "きしだなおき", 2);
    Book book3 = new Book("良いコード/悪いコードで学ぶ設計入門", "仙波大也", 3);

    List<Book> bookList = List.of(book1, book2, book3);
    Library library = new Library(bookList);
    Scanner scanner = new Scanner(System.in);
    int searchType = 0;

    // do-whileで正しい検索タイプを選ばれなかった時にループを回す。

    do {
      System.out.println("検索タイプを次の1から3の数字で選択してください：");
      System.out.println("1: 書名検索");
      System.out.println("2: 著者検索");
      System.out.println("3: 番号検索");
      try {
        searchType = scanner.nextInt();
        scanner.nextLine();

        // 選択された番号によって処理が変わるswitch文
        switch (searchType) {
          case 1:
            System.out.println("書名を入力してください");
            String title = scanner.nextLine();
            List<Book> titleSearchResults = library.searchByTitle(title);
            titleSearchResults.forEach(System.out::println);
            break;

          case 2:
            System.out.println("著者を入力してください");
            String author = scanner.nextLine();
            List<Book> authorSearchResults = library.searchByAuthor(author);
            authorSearchResults.forEach(System.out::println);
            break;

          case 3:
            System.out.println("番号を入力してください");
            int number = scanner.nextInt();
            List<Book> numberSearchResults = library.searchByNumber(number);
            numberSearchResults.forEach(System.out::println);
            break;
          // 正しい番号が入力されなかった場合のdefault
          default:
            System.out.println("不正な入力です。1から3の番号を選んでください。");
        }
        // 1〜3以外の数字が入力された際にループをかける
      } catch (InputMismatchException e) {
        System.out.println("InputMismatchException発生！");
        System.out.println("1から3の番号を選んでください。");
        scanner.next();
      }
    } while (searchType < 1 || searchType > 3);
  }
}
