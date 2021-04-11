package com.meli.api.mutant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatResult {

	@JsonProperty("count_mutant_dna")
	private Long countMutantDna;
	@JsonProperty("count_human_dna")
	private Long countHumanDna;
	private double ratio;

	public StatResult() {
	}

	public StatResult(Long countMutantDna, Long countHumanDna) {
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;

		Long totalRecords = countMutantDna + countHumanDna;
		this.ratio = Math.round(((double) this.countMutantDna / totalRecords) * 100.0);
	}

	/**
	 * @return countMutantDna
	 */
	public Long getCountMutantDna() {
		return countMutantDna;
	}

	/**
	 * @param countMutantDna set countMutantDna
	 */
	public void setCountMutantDna(Long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	/**
	 * @return countHumanDna
	 */
	public Long getCountHumanDna() {
		return countHumanDna;
	}

	/**
	 * @param countHumanDna set countHumanDna
	 */
	public void setCountHumanDna(Long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	/**
	 * @return ratio
	 */
	public double getRatio() {
		return ratio;
	}

	/**
	 * @param ratio set ratio
	 */
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}
