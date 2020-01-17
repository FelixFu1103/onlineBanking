package com.cmpe202teamproject.obs.DataAccessObject;

import com.cmpe202teamproject.obs.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>  {

    Payment findFirstByOrderByPaymentIdDesc();

    @Query("select a from Payment a where a.date BETWEEN :startDate and :endDate")
    List<Payment> findPaymentTransactions(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Payment> findAll();
}
