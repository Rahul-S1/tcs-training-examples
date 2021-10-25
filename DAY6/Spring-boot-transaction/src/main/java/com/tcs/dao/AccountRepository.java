package com.tcs.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.tcs.entity.Account;
/*
 * You can call methods like save(object), findAll(), findById()
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
