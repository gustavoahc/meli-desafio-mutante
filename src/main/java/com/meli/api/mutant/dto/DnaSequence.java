package com.meli.api.mutant.dto;

import java.util.List;

/**
 * DTO para mapear el DNA recibido
 *
 */
public class DnaSequence {

	private List<String> dna;

	/**
	 * @return dna
	 */
	public List<String> getDna() {
		return dna;
	}

	/**
	 * @param dna
	 */
	public void setDna(List<String> dna) {
		this.dna = dna;
	}

}