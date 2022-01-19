package com.pj.web;

import com.pj.model.Book;
import com.pj.model.Loan;
import com.pj.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
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

	@GetMapping("/find/all")
	public ResponseEntity<List<Loan>> getBooks()
	{
		return ResponseEntity.ok(bookService.findAll());
	}

	@GetMapping("/find/id/{id}")
	public ResponseEntity<Optional<Loan>> getBookById(@PathVariable String id)
	{
		return ResponseEntity.ok(bookService.findById(id));
	}
	@GetMapping("/find/byStudent/{StudentID}")
	public ResponseEntity<List<Loan>> getLoanByStudent(@PathVariable String StudentID)
	{
		return ResponseEntity.ok(bookService.findByStudentID(StudentID));
	}
	@GetMapping("/find/byBook/{BookID}")
	public ResponseEntity<List<Loan>> getLoanByBookID(@PathVariable String BookID)
	{
		return ResponseEntity.ok(bookService.findByStudentID(BookID));
	}

	@PostMapping("/save")
	@Transactional
	public ResponseEntity<Loan> saveBook(@RequestBody Loan loan)
	{

		Book book = this.restTemplate.getForObject("http://localhost:9091/book/loan/"+loan.getBookID(),Book.class);
		return ResponseEntity.ok(bookService.insertBook(loan));
	}



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
