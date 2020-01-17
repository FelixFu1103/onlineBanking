package com.cmpe202teamproject.obs.DataAccessObject;
import com.cmpe202teamproject.obs.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT c FROM Customer c WHERE c.customerName = ?1 and c.password = ?2")
    Customer validateCustomer(String customerName, String password);

    @Query("SELECT c FROM Customer c WHERE c.customerName = ?1")
    Customer findByName(String customerName);



}
