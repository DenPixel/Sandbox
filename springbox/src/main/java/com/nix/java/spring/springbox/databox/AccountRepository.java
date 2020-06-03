package com.nix.java.spring.springbox.databox;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findByNickname(String nickname);

    Account findById(int id);

    List<Account> findByName(String name);
}
