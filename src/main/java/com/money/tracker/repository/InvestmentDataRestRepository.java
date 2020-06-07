package com.money.tracker.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.money.tracker.model.Investment;

@RepositoryRestResource(path = "investments", collectionResourceRel = "investments")
public interface InvestmentDataRestRepository extends PagingAndSortingRepository<Investment, Long> {
	
	public List<Investment> findByAccountIdAndUserId(Long accountId, Long userId);

}
