package com.money.tracker.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.money.tracker.model.Account;

@RepositoryRestResource(path = "accounts", collectionResourceRel = "accounts")
public interface AccountDataRestRepository extends PagingAndSortingRepository<Account, Long> {

}