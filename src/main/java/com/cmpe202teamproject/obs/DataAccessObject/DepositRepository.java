package com.cmpe202teamproject.obs.DataAccessObject;

import com.cmpe202teamproject.obs.Model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {

    @Query("select a from Deposit a where a.date BETWEEN :startDate and :endDate")
    List<Deposit> findDepositTransactions(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Deposit> findAll();
}
