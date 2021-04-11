package com.meli.api.mutant.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.meli.api.mutant.dto.DnaSequence;

public interface MutantService {

	public ResponseEntity<String> isMutant(DnaSequence dna);

}
