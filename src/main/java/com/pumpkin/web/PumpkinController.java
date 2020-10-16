package com.pumpkin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pumpkin.business.Pumpkin;
import com.pumpkin.db.PumpkinRepo;

@CrossOrigin
@RestController
@RequestMapping("/pumpkins")
public class PumpkinController 
{
	@Autowired
	private PumpkinRepo pumpkinRepo;
	
	// List all Pumpkins
	@GetMapping("/")
	public List<Pumpkin> getAllPumpkins() {
		return pumpkinRepo.findAll();
	}
	
	// Get a Pumpkin by id
	@GetMapping("/{id}")
	public Pumpkin getPumpkin(@PathVariable int id) {
		return pumpkinRepo.getOne(id);
	}
	// Add a Pumpkin
	@PostMapping("/")
	public Pumpkin addPumpkin(@RequestBody Pumpkin p)
	{
		if(p != null)
			return pumpkinRepo.save(p);
		else
		{
			System.out.println("No pumpkin given");
			return null;
		}
	}
	
	// Edit a Pumpkin
	@PutMapping("/")
	public Pumpkin updatePumpkin(@RequestBody Pumpkin p)
	{
		if(p != null)
			return pumpkinRepo.save(p);
		else
		{
			System.out.println("No pumpkin given");
			return null;
		}
	}
	
	// Delete a Pumpkin
	@DeleteMapping("/")
	public void deletePumpkin(@RequestBody Pumpkin p)
	{
		if(p != null)
			pumpkinRepo.delete(p);
		else
			System.out.println("No Pumpkin given");
	}
}