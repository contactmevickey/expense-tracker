package com.money.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.money.tracker.dto.SavingDto;
import com.money.tracker.service.InvestmentService;

@Controller
@RequestMapping("/expense")
public class InvestmentController {
	
	@Autowired
	InvestmentService investmentService;
	
	@GetMapping(path = "/savings", produces = "application/json")
    public @ResponseBody SavingDto getSavingsTillDate(@RequestParam Long userId, @RequestParam Long accountId) {
		return investmentService.getSavings(accountId, userId);
    }
}