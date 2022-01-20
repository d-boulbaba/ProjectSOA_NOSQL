package com.pj.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Data
@Getter
@Setter
public class LoanDetail
{
    @Id
    private String id;
    private Student student;
    private Book book;

    public LoanDetail()
    {
    }

    public LoanDetail(String id, Student student, Book book)
    {
        this.id = id;
        this.student = student;
        this.book = book;
    }
}

