package com.money.tracker.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.money.tracker.model.User;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserDataRestRepository extends PagingAndSortingRepository<User, Long> {

}