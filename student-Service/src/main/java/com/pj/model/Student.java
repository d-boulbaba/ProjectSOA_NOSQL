package com.pj.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Setter
@Getter
public class Student
{
    @Id
    private Long cin;
    private String firstName;
    private String lastName;


    public Student(long cin, String firstName, String lastName) {
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Student(){

    }
}
