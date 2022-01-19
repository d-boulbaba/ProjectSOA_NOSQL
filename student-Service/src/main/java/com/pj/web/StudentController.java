package com.pj.web;

import com.pj.model.Student;
import com.pj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController
{
	private final StudentService customerService;

	@Autowired
	public StudentController(StudentService customerService)
	{
		this.customerService = customerService;
	}
	@GetMapping("/find/Cin/{Cin}")
	public ResponseEntity<Student> findByCin(@PathVariable Long Cin)
	{
		return ResponseEntity.ok(customerService.findByCin(Cin).get());
	}
	@GetMapping("/find/all")
	public ResponseEntity<List<Student>> getBooks()
	{
		return ResponseEntity.ok(customerService.findAll());
	}


	@GetMapping("/find/first_name/{firstName}")
	public ResponseEntity<Student> findByFirstName(@PathVariable String firstName)
	{
		return ResponseEntity.ok(customerService.findByFirstName(firstName));
	}

	@GetMapping("/find/last_name/{lastName}")
	public ResponseEntity<List<Student>> findByLastName(@PathVariable String lastName)
	{
		return ResponseEntity.ok(customerService.findByLastName(lastName));
	}

    @PostMapping("/save")
    public ResponseEntity<Student> saveBook(@RequestBody Student customer)
    { Student s = customer;
         return ResponseEntity.ok(customerService.insert(customer));
    }
}

