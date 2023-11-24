package com.example.ung_dung_muon_sach.aop;

import com.example.ung_dung_muon_sach.dto.PeopleDto;
import com.example.ung_dung_muon_sach.exception.PersonIdNotExist;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.People;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IPeopleService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IPeopleService iPeopleService;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private int count;

    @AfterReturning("execution(* com.example.ung_dung_muon_sach.controller.BookController.*(..))")
    public void showMethod(JoinPoint joinPoint) {
        System.out.println("------------------------------------------------------------------");
        String methodName = joinPoint.getSignature().getName();
        logger.info("Tên phương thức: " + methodName);
        count++;
        System.out.println("Count: " + count);
        System.out.println("------------------------------------------------------------------");
    }

    @AfterReturning("execution(* com.example.ung_dung_muon_sach.controller.BookController.borrowBooks(..))")
    public void changeBookBorrow(JoinPoint joinPoint) {
        System.out.println("------------------------------------------------------------------");
        Object[] args = joinPoint.getArgs();
        Integer bookId = (Integer) args[0];
        Book book = iBookService.findByBookId(bookId);
        System.out.println("success : " + book.getBookName() + ": " + book.getNumberOfBooks());
        System.out.println("------------------------------------------------------------------");

    }

    @Before("execution(* com.example.ung_dung_muon_sach.controller.BookController.giveBookBack(..))")
    public void changeBookPay(JoinPoint joinPoint) throws PersonIdNotExist {

        Object[] args = joinPoint.getArgs();
        PeopleDto peopleDto = (PeopleDto) args[0];
        int id = Integer.parseInt(peopleDto.getPeopleId());
        if (iPeopleService.findPeopleByPeopleId(id) == null) {
            return;
        } else {
            System.out.println("------------------------------------------------------------------");
            People people = iPeopleService.findPeopleByPeopleId(id);
            Book book = iBookService.findByBookId(people.getBook().getBookId());
            System.out.println("success : " + book.getBookName() + ": " + (book.getNumberOfBooks() + 1));
        }
        System.out.println("------------------------------------------------------------------");
    }
}
