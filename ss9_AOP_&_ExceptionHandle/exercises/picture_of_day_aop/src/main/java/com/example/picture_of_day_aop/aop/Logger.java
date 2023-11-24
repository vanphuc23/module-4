package com.example.picture_of_day_aop.aop;

import com.example.picture_of_day_aop.model.Picture;
import com.example.picture_of_day_aop.util.WriteException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class Logger {

    @AfterThrowing(value = "execution(* com.example.picture_of_day_aop.controller.PictureController.create(..))")
    public void Bad(JoinPoint joinPoint) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        Object[] object = joinPoint.getArgs();
        Picture picture = (Picture) object[0];
        System.out.println("------------------Error---------------");
        System.out.println("Auther: "+picture.getAuthor()+" -- Feedback: "+picture.getFeedBack()+" -- "+formatter.format(localDateTime));
        System.out.println("--------------------------------------");
        String pictureException = "Auther: "+picture.getAuthor()+" -- Feedback: "+picture.getFeedBack()+" -- "+formatter.format(localDateTime);
        WriteException.writeException(pictureException);
    }
}
