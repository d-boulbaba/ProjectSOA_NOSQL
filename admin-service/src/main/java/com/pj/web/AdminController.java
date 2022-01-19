package com.pj.web;

import com.pj.model.Admin;
import com.pj.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController
{
	private final AdminService customerService;

	@Autowired
	public AdminController(AdminService customerService)
	{
		this.customerService = customerService;
	}
	@GetMapping("/find/Cin/{Cin}")
	public ResponseEntity<Admin> findByCin(@PathVariable Long Cin)
	{
		return ResponseEntity.ok(customerService.findByCin(Cin).get());
	}
	@GetMapping("/find/all")
	public ResponseEntity<List<Admin>> getBooks()
	{
		return ResponseEntity.ok(customerService.findAll());
	}


	@GetMapping("/find/first_name/{firstName}")
	public ResponseEntity<Admin> findByFirstName(@PathVariable String firstName)
	{
		return ResponseEntity.ok(customerService.findByFirstName(firstName));
	}

	@GetMapping("/find/last_name/{lastName}")
	public ResponseEntity<List<Admin>> findByLastName(@PathVariable String lastName)
	{
		return ResponseEntity.ok(customerService.findByLastName(lastName));
	}

    @PostMapping("/save")
    public ResponseEntity<Admin> saveBook(@RequestBody Admin customer)
    { Admin s = customer;
         return ResponseEntity.ok(customerService.insert(customer));
    }
}

