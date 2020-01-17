package com.cmpe202teamproject.obs.DataAccessObject;

import com.cmpe202teamproject.obs.Model.Account;
import com.cmpe202teamproject.obs.Model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Integer> {

    Fees findFirstByOrderByFeesIdDesc();

    @Query("SELECT a FROM Account a WHERE a.accountNum = ?1")
    Account findAccount(Integer accountNum);

    @Query("select a from Fees a where a.date BETWEEN :startDate and :endDate")
    List<Fees> findFeesBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Fees> findAll();
}
