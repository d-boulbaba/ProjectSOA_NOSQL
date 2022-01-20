package com.pj.web;

import com.pj.model.Student;
import com.pj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController
{
	private final StudentService customerService;

	@Autowired
	public StudentController(StudentService customerService)
	{
		this.customerService = customerService;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/Cin/{Cin}")
	public ResponseEntity<Student> findByCin(@PathVariable Long Cin)
	{
		return ResponseEntity.ok(customerService.findByCin(Cin).get());
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/all")
	public ResponseEntity<List<Student>> getBooks()
	{
		return ResponseEntity.ok(customerService.findAll());
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/find/first_name/{firstName}")
	public ResponseEntity<Student> findByFirstName(@PathVariable String firstName)
	{
		return ResponseEntity.ok(customerService.findByFirstName(firstName));
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/last_name/{lastName}")
	public ResponseEntity<List<Student>> findByLastName(@PathVariable String lastName)
	{
		return ResponseEntity.ok(customerService.findByLastName(lastName));
	}
	@CrossOrigin(origins = "*")
    @PostMapping("/save")
    public ResponseEntity<Student> saveBook(@RequestBody Student customer)
    { Student s = customer;
         return ResponseEntity.ok(customerService.insert(customer));
    }

	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{cin}")
	public ResponseEntity<?> deleteBook(@PathVariable Long cin)
	{
		Optional<Student> student =  customerService.findByCin(cin);
		if(student.isPresent())
		{customerService.delete(student.get());
		return new ResponseEntity<>(HttpStatus.OK);}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}

