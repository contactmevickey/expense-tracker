package com.money.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.tracker.dto.SavingDto;
import com.money.tracker.model.Investment;
import com.money.tracker.repository.InvestmentDataRestRepository;

@Service
public class InvestmentService {
	
	@Autowired
	InvestmentDataRestRepository investmentDataRestRepository;
	
	@Autowired
	SavingDto savingDto;
	
	public SavingDto getSavings(Long accountId, Long userId) {
	 	List<Investment> investmentList = investmentDataRestRepository.findByAccountIdAndUserId(accountId, userId);
	 	float temp = 0;
        for (int i = 0; i < investmentList.size(); i++) {
        	temp += investmentList.get(i).getPrincipal();
        }
        savingDto.setSavings(temp);
        return savingDto;
	}
}