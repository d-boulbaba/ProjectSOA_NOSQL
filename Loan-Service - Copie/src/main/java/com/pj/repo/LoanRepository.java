package com.pj.repo;

import com.pj.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface LoanRepository extends MongoRepository<Loan,String>
{

    List<Loan> findLoanByStudentID(String StudentID);
    List<Loan> findLoanByBookID(String BookID);

}
