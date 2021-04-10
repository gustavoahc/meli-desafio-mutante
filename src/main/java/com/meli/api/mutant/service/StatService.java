package com.meli.api.mutant.service;

import java.util.List;

import com.meli.api.mutant.model.Stat;

public interface StatService {

	public List<Stat> findAllStats();

	public Stat saveStat(Stat stat);

}
