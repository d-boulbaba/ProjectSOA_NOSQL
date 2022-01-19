package com.pj.service;

import com.pj.model.Loan;
import com.pj.repo.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoanServiceImpl implements LoanService
{

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository bookRepository)
    {
        this.loanRepository=bookRepository;
    }

    @Override
    public List<Loan> findAll()
    {
        return loanRepository.findAll();
    }

    @Override
    public Optional<Loan> findById(String id)
    {
        return loanRepository.findById(id);
    }

    @Override
    public List<Loan> findByStudentID(String id) {
        String idd = id;

        List<Loan> l =         loanRepository.findLoanByStudentID(id);
        return l;
    }

    @Override
    public List<Loan> findByBookID(String id) {
        return loanRepository.findLoanByBookID(id);
    }


    @Override
    public Loan insertBook(Loan book)
    {
        return loanRepository.insert(book);
    }

    @Override
    public void insertAllBooks(Iterable<Loan> books)
    {
        loanRepository.insert(books);
    }

    @Override
    public Loan updateBook(Loan book)
    {
        return loanRepository.save(book);
    }
    @Override
    public void deleteBook(Loan book)
    {
        loanRepository.delete(book);
    }

    @Override
    public void deleteById(String id)
    {
        loanRepository.deleteById(id);
    }

    @Override
    public void deleteAll()
    {
        loanRepository.deleteAll();
    }
}
