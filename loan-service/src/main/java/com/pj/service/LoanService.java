package com.pj.service;

import com.pj.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService
{
    List<Loan> findAll();

    Optional<Loan> findById(String id);

    List<Loan> findByStudentID(String id);

    List<Loan> findByBookID(String id);

    Loan insertBook(Loan book);

    void insertAllBooks(Iterable<Loan> book);

    Loan updateBook(Loan book);

    void deleteBook(Loan book);

    void deleteById(String id);

    void deleteAll();
}
