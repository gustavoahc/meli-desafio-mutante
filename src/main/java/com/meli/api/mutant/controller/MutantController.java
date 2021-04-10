package com.meli.api.mutant.controller;

import com.meli.api.mutant.model.Stat;
import com.meli.api.mutant.dto.DnaSequence;
import com.meli.api.mutant.business.MutantBusiness;
import com.meli.api.mutant.business.StatBusiness;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MutantController {

	private MutantBusiness mutantBusiness;
	@Autowired
	private StatBusiness statBusiness;

	public MutantController() {
		this.mutantBusiness = new MutantBusiness();
		this.statBusiness = new StatBusiness();
	}

	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "List of stats"),
		@ApiResponse(responseCode = "403", description = "Error returning stats") })
	@GetMapping(value = "/stats")
	public List<Stat> stats()
	{
		return this.statBusiness.findAllStats();
	}

	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Mutant DNA received"),
		@ApiResponse(responseCode = "403", description = "Not mutant DNA received") })
	@PostMapping(value = "/mutant")
	public ResponseEntity<String> validateDNA(@RequestBody DnaSequence dna) {
		return this.mutantBusiness.isMutant(dna);
	}

}
