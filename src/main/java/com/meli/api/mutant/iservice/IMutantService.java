package com.meli.api.mutant.iservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.meli.api.mutant.dto.DnaSequence;

public interface IMutantService {

	public ResponseEntity<String> isMutant(DnaSequence dna);

}
