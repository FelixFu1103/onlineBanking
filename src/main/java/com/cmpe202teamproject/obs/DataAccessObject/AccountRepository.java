package com.cmpe202teamproject.obs.DataAccessObject;

import com.cmpe202teamproject.obs.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.accountNum = ?1")
    Account findAccount(Integer accountNum);

    @Transactional
    @Modifying
    @Query("Delete FROM Account a WHERE a.accountNum = ?1")
    void deleteAccount(Integer accountNum);

}
