package com.meli.api.mutant.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.meli.api.mutant.model.Mutant;
import com.meli.api.mutant.model.Stat;
import com.meli.api.mutant.service.MutantService;
import com.meli.api.mutant.dto.DnaSequence;
import com.meli.api.mutant.business.StatBusiness;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantBusiness implements MutantService {

	@Autowired
	private StatBusiness statBusiness;

	public MutantBusiness() {
		this.statBusiness = new StatBusiness();
	}

	public ResponseEntity<String> isMutant(DnaSequence dna)
	{
		ResponseEntity<String> response = null;
		Stat newStat = new Stat();
		StringBuilder dnaString = new StringBuilder();
		
		try {
			String[] array = dna.getDna().toArray(new String[0]);
			boolean mutant = this.validateDnaSequence(array);
			
			for(String str : dna.getDna())
			{
				dnaString.append(str);
				dnaString.append(",");
			}
			dnaString.setLength(dnaString.length()-1);

			
			newStat.setDna(dnaString.toString());
			
			if (mutant) {
				newStat.setMutant(true);
				response = new ResponseEntity<>("Mutant DNA!!!", HttpStatus.OK);
			} else {
				newStat.setMutant(false);
				response = new ResponseEntity<>("Human DNA!!!", HttpStatus.FORBIDDEN);
			}
			
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
		}

		if (this.statBusiness.isValidDna(dnaString.toString())) {
			Stat stat = this.statBusiness.saveStat(newStat);
		}
		
		return response;
	}

	private boolean validateDnaSequence(String[] dnaSecuence) throws Exception {
		List<String> dna = new ArrayList<String>(Arrays.asList(dnaSecuence));

		return new Matrix(dna).validateMatrix();
	}

}
