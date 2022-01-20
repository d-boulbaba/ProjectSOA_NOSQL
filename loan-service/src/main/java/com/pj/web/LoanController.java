package com.pj.web;

import com.pj.model.Book;
import com.pj.model.Loan;
import com.pj.model.LoanDetail;
import com.pj.model.Student;
import com.pj.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/loan")
public class LoanController
{
	private final LoanService bookService;
	RestTemplate restTemplate= new RestTemplate();

	@Autowired
	public LoanController(LoanService bookService)
	{
		this.bookService = bookService;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/all")
	public ResponseEntity<List<LoanDetail>> getBooks()
	{
		List<LoanDetail> loanDetails =new ArrayList<>();
		Book book;
		Student student;
		for (Loan loan : bookService.findAll()
		) {
			book = this.restTemplate.getForObject("http://localhost:9091/book/find/id/"+loan.getBookID(), Book.class);
			student = this.restTemplate.getForObject("http://localhost:9093/student/find/Cin/"+loan.getStudentID(),Student.class);
			loanDetails.add(new LoanDetail(loan.getId(),student,book));

		}

		return ResponseEntity.ok(loanDetails);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/id/{id}")
	public ResponseEntity<Optional<Loan>> getBookById(@PathVariable String id)
	{
		return ResponseEntity.ok(bookService.findById(id));
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/byStudent/{StudentID}")
	public ResponseEntity<List<LoanDetail>> getLoanByStudent(@PathVariable String StudentID)
	{
		List<LoanDetail> loanDetails =new ArrayList<>();
		Book book;
		Student student ;
		for (Loan loan : bookService.findByStudentID(StudentID)
		) {
			book = this.restTemplate.getForObject("http://localhost:9091/book/find/id/"+loan.getBookID(), Book.class);
			student = this.restTemplate.getForObject("http://localhost:9093/student/find/Cin/"+loan.getStudentID(),Student.class);
			loanDetails.add(new LoanDetail(loan.getId(),student,book));

		}

		return ResponseEntity.ok(loanDetails);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/byBook/{BookID}")
	public ResponseEntity<List<Loan>> getLoanByBookID(@PathVariable String BookID)
	{
		//Book book = this.restTemplate.getForObject("http://localhost:9091/book/loan/"+loan.getBookID(),Book.class);
		return ResponseEntity.ok(bookService.findByStudentID(BookID));
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/save")
	@Transactional
	public ResponseEntity<Loan> saveBook(@RequestBody Loan loan)
	{

		Book book = this.restTemplate.getForObject("http://localhost:9091/book/loan/"+loan.getBookID(),Book.class);
		return ResponseEntity.ok(bookService.insertBook(loan));
	}


	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	@Transactional
	public ResponseEntity<String> deleteBook(@PathVariable String id)
	{
		Optional<Loan> loan =  bookService.findById(id);
		if( loan.isPresent())
		{
			String BookID = loan.get().getBookID();
			Book book = this.restTemplate.getForObject("http://localhost:9091/book/return/"+BookID,Book.class);
			bookService.deleteById(id);
			return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);

		}
		return   ResponseEntity.status(HttpStatus.FORBIDDEN)
			.body("Error return book");

	}
}
