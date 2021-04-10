package com.meli.api.mutant.business;

import java.util.ArrayList;
import java.util.List;

import com.meli.api.mutant.model.Stat;
import com.meli.api.mutant.service.StatService;
import com.meli.api.mutant.repository.StatRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatBusiness implements StatService {

	@Autowired
	private StatRepository statRepository;

	@Override
	public List<Stat> findAllStats(){
		return statRepository.findAll();
	}

	@Override
	public Stat saveStat(Stat stat){
		return statRepository.save(stat);
	}

}
