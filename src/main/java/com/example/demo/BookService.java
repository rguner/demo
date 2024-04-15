package com.example.demo;

import com.example.demo.model.Book;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Slf4j
public class BookService {

    @PostConstruct
    public void getBookName() {
            Book book = new Book();
            book.setTitle("Spring Boot");
            System.out.println(book.getTitle());
    }

    @PostConstruct
    public void invoiceAmount() {
        BigDecimal dueAmount = new BigDecimal(100.1244);
        BigDecimal sonuc = dueAmount.setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("Rounded Amount " + sonuc);
    }

    @PostConstruct
    public void logWithExceptionTrace() {
        Exception e = new NullPointerException("This is an NullPointerException");
        log.warn("This is a warning message {} {}", 1, 2, 3, 4, e); // it prints the exception trace
        log.warn("This is a warning message2 {} {}", 1, 2, 3, 4, e.getMessage()); // it doesnt print getMessage because it is not a placeholder
    }
}
