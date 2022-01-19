package com.pj.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Data
@Getter
@Setter
public class Loan
{
    @Id
    private String id;
    private String studentID;
    private String bookID;


    public Loan()
    {
    }

    public Loan(String studentID, String bookID) {
        this.studentID = studentID;
        this.bookID = bookID;
    }
}
