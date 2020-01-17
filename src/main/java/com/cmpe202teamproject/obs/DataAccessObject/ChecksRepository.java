package com.cmpe202teamproject.obs.DataAccessObject;

import com.cmpe202teamproject.obs.Model.Checks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ChecksRepository extends JpaRepository<Checks,Integer> {

    @Query("select a from Checks a where a.date BETWEEN :startDate and :endDate")
    List<Checks> findCheckTransactions(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Checks> findAll();
}
