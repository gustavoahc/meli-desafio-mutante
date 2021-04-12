package com.meli.api.mutant.iservice;

import java.util.List;

import com.meli.api.mutant.model.*;

import org.springframework.http.ResponseEntity;

public interface IStatService {

	public List<Stat> findAllStats();

	public Stat saveStat(Stat stat);

	public ResponseEntity<StatResult> countStats();

	public boolean isValidDna(String dna);

}
