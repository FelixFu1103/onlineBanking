package com.cmpe202teamproject.obs.DataAccessObject;
import com.cmpe202teamproject.obs.Model.ExternalPayee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalPayeeRepository extends JpaRepository<ExternalPayee, Integer> {

    @Query("SELECT e FROM ExternalPayee e Where e.payeeName = ?1")
    ExternalPayee findExternalPayee(String externalPayeeName);



}
