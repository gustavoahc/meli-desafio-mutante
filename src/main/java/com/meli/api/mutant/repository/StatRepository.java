package com.meli.api.mutant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meli.api.mutant.model.*;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

	@Query(value = "select new com.meli.api.mutant.model.StatResult(count(case when s.mutant = true then 1 else null end), count(case when s.mutant = false then 1 else null end)) from Stat s")
	StatResult countStats();

	@Query(value = "select s from Stat s where s.dna = ?1")
	Stat validateDna(String dna);

}
