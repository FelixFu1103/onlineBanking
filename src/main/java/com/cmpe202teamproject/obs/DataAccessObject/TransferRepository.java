package com.cmpe202teamproject.obs.DataAccessObject;

import com.cmpe202teamproject.obs.Model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

    Transfer findFirstByOrderByTransferIdDesc();

    @Query("select a from Transfer a where a.date BETWEEN :startDate and :endDate")
    List<Transfer> findTransferTransactions(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Transfer> findAll();
}
