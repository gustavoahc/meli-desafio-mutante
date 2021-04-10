package com.meli.api.mutant.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "stat")
public class Stat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stat_id")
	Long statId;

	@Column(name = "is_mutant")
	boolean mutant;

	@Column(name = "dna")
	String dna;

	/**
	 * @return the statId
	 */
	public Long getStatId(){
		return this.statId;
	}

	/**
	 * @param set the statId
	 */
	public void setStatId(Long statId) {
		this.statId = statId;
	}

	/**
	 * @return if is mutant
	 */
	public boolean isMutant(){
		return this.mutant;
	}

	/**
	 * @return set mutant
	 */
	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}

	/**
	 * @return the DNA
	 */
	public String getDna(){
		return this.dna;
	}

	/**
	 * @param set the DNA
	 */
	public void setDna(String dna) {
		this.dna = dna;
	}

}
