package com.pj.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Data
@Getter
@Setter
public class    Book
{
    @Id
    private String id;
    private String title;
    private Integer numberOfPages;
    private Integer NumberCopies;
    private Integer NumberCopiesAvailable;
    private String author;

    public Book()
    {
    }

    public Book(String title, Integer numberOfPages, Integer NumberCopies,Integer NumberCopiesAvailable, String author)
    {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.NumberCopies = NumberCopies;
        this.NumberCopiesAvailable = NumberCopiesAvailable;
        this.author = author;
    }
}
