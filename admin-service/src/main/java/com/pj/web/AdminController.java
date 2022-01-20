package com.pj.web;

import com.pj.model.Admin;
import com.pj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController
{
	private final AdminService customerService;

	@Autowired
	public AdminController(AdminService customerService)
	{
		this.customerService = customerService;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/Cin/{Cin}")
	public ResponseEntity<Admin> findByCin(@PathVariable Long Cin)
	{
		return ResponseEntity.ok(customerService.findByCin(Cin).get());
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/all")
	public ResponseEntity<List<Admin>> getBooks()
	{
		return ResponseEntity.ok(customerService.findAll());
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/find/first_name/{firstName}")
	public ResponseEntity<Admin> findByFirstName(@PathVariable String firstName)
	{
		return ResponseEntity.ok(customerService.findByFirstName(firstName));
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/find/last_name/{lastName}")
	public ResponseEntity<List<Admin>> findByLastName(@PathVariable String lastName)
	{
		return ResponseEntity.ok(customerService.findByLastName(lastName));
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/save")
    public ResponseEntity<Admin> saveBook(@RequestBody Admin customer)
    { Admin s = customer;
         return ResponseEntity.ok(customerService.insert(customer));
    }
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{cin}")
	public ResponseEntity<?> deleteBook(@PathVariable Long cin)
	{
		Optional<Admin> student =  customerService.findByCin(cin);
		if(student.isPresent())
		{customerService.delete(student.get());
			return new ResponseEntity<>(HttpStatus.OK);}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}

