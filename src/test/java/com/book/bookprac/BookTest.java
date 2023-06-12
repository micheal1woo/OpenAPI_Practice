package com.book.bookprac;

import com.book.bookprac.book.Book;
import com.book.bookprac.book.BookRepository;
import com.book.bookprac.jumoon.Jumoon;
import com.book.bookprac.jumoon.JumoonRepository;
import com.book.bookprac.jumoon.JumoonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private JumoonRepository jumoonRepository;
    @Autowired
    private JumoonService jumoonService;

    @Test
    public void 메인페이지조회(){
        // given
        Book save1 = new Book("title1", 4000, 4, "저자", "출판사", "이미지", "카테고리", "소분류 카테고리", 1994, 12, 4);
        Book save2 = new Book("title2", 4000, 4, "저자", "출판사", "이미지", "카테고리", "소분류 카테고리", 1994, 12, 4);
        bookRepository.save(save1);
        bookRepository.save(save2);
        // when
        List<Book> books = bookRepository.findAll();

        // then
        assertEquals(books.get(0).getTitle(), "title1");
        assertEquals(books.get(1).getTitle(), "title2");
    }

    @Test
    public void 저장하기() {

        // given
        Book book = new Book("title", 4000, 4, "저자", "출판사", "이미지", "카테고리", "소분류 카테고리", 1994, 12, 4);

        // when
        Book savedBook = bookRepository.save(book);

        // then
        assertEquals("title", savedBook.getTitle());
    }

    @Test
    public void 검색기능() {
        // given
        Book book1 = new Book("토르", 4000, 4, "저자", "출판사", "이미지", "카테고리", "소분류 카테고리", 1994, 12, 4);
        Book book2 = new Book("비욘", 4000, 4, "저자", "출판사", "이미지", "카테고리", "소분류 카테고리", 1994, 12, 4);
        Book book3 = new Book("토르비욘", 4000, 4, "저자", "출판사", "이미지", "카테고리", "소분류 카테고리", 1994, 12, 4);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);


        // when
        String keyword1 = "토르";
        String keyword2 = "비욘";
        List<Book> books = bookRepository.findBookByTitleContains(keyword1);


        // then
        assertEquals(books.get(0).getTitle(), "토르");
        assertEquals(books.get(1).getTitle(), "토르비욘");
    }

    @Test
    public void 구매목록_저장하기(){
        // given
        Book book1 = new Book("토르", 4000, 4, "저자", "출판사", "이미지", "카테고리", "소분류 카테고리", 1994, 12, 4);
        bookRepository.save(book1);
        Jumoon jumoon = new Jumoon(book1);
        // when
        Jumoon check = jumoonRepository.save(jumoon);

        // then
        assertEquals(check.getBook(), book1);
    }

}
