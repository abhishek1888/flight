package com.hexa.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.flight.dto.flightDTO;
import com.hexa.flight.service.flightservice;

@RequestMapping("/api/flights")
@RestController
@CrossOrigin(origins="*")
public class flightcontroller {
      
	@Autowired
	private flightservice fservice;
	
	@GetMapping("/getallflight")
	public ResponseEntity<List<flightDTO>> getallflights()
	{
		return ResponseEntity.ok().body(fservice.getallflights());
		
	}
	@GetMapping("/getflightByid")
	public ResponseEntity<flightDTO> getflightbyid(@RequestParam String flightnumber)
	{
		return ResponseEntity.ok().body(fservice.getflightbyid(flightnumber));
		
	}
	@PostMapping("/createflight")
	public ResponseEntity<flightDTO> createflight(@RequestBody flightDTO flightdto)
	{
		return ResponseEntity.ok().body(fservice.createflight(flightdto));
		
	}
	
	@PutMapping("/updateflight")
	public ResponseEntity<flightDTO> updateflight(@RequestBody flightDTO flightdto,@RequestParam String flightnumber)
	{
		return ResponseEntity.ok().body(fservice.updateflight(flightdto, flightnumber));
		
	}
	
	@DeleteMapping("/deleteflight")
	public ResponseEntity<String> deleteflight(@RequestParam String flightnumber)
	{
		return ResponseEntity.ok().body(fservice.deleteflight(flightnumber));
		
	}
}
