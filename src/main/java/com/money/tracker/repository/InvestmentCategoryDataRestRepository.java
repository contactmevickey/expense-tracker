package com.money.tracker.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.money.tracker.model.InvestmentCategory;

@RepositoryRestResource(path = "investmentcategorys", collectionResourceRel = "investmentcategorys")
public interface InvestmentCategoryDataRestRepository extends PagingAndSortingRepository<InvestmentCategory, Long> {

}
