package com.meli.api.mutant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.meli.api.mutant.model.*;
import com.meli.api.mutant.dto.DnaSequence;
import com.meli.api.mutant.iservice.*;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MutantController {

	@Autowired
	private IMutantService mutantService;
	@Autowired
	private IStatService statService;

	@ApiResponses(value = {
		@ApiResponse(responseCode = "200"),
		@ApiResponse(responseCode = "403") })
	@GetMapping(value = "/list")
	public List<Stat> completeList()
	{
		return this.statService.findAllStats();
	}

	@ApiResponses(value = {
		@ApiResponse(responseCode = "200"),
		@ApiResponse(responseCode = "403") })
	@GetMapping(value = "/stats")
	public ResponseEntity<StatResult> stats()
	{
		return this.statService.countStats();
	}

	@ApiResponses(value = {
		@ApiResponse(responseCode = "200"),
		@ApiResponse(responseCode = "403") })
	@PostMapping(value = "/mutant")
	public ResponseEntity<String> validateDNA(@RequestBody DnaSequence dna) {
		return this.mutantService.isMutant(dna);
	}

}
