package com.money.tracker.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.money.tracker.model.Expenditure;

@RepositoryRestResource(path = "expenditures", collectionResourceRel = "expenditures")
public interface ExpenditureDataRestRepository extends PagingAndSortingRepository<Expenditure, Long> {

}