package com.meli.api.mutant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.api.mutant.model.Stat;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

}
