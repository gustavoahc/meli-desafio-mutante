package com.meli.api.mutant.business;

import java.util.ArrayList;
import java.util.List;

import com.meli.api.mutant.model.*;
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
		return this.statRepository.findAll();
	}

	@Override
	public Stat saveStat(Stat stat){
		return this.statRepository.save(stat);
	}

	public ResponseEntity<StatResult> countStats(){
		ResponseEntity<StatResult> response = null;
		StatResult statResult = null;

		//try {
			statResult = this.statRepository.countStats();
			response = new ResponseEntity<StatResult>(statResult, HttpStatus.OK);
		/*} catch (Exception e) {
			response = new ResponseEntity<StatResult>(HttpStatus.BAD_REQUEST);
		}*/
		
		return response;
	}

}
