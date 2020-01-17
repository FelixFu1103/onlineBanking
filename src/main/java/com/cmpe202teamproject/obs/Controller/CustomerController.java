package com.cmpe202teamproject.obs.Controller;

import com.cmpe202teamproject.obs.Model.*;
import com.cmpe202teamproject.obs.Service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Object createCustomer(@RequestBody @Valid Customer customer){
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public Object sigInCustomer(@RequestBody @Valid Customer customer){
        return customerService.signInCustomer(customer);
    }

    @RequestMapping(value = "/add_account", method = RequestMethod.POST)
    public Object addAccount(@RequestBody @Valid Account account){
           return customerService.addAccount(account);
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Customer getMyInfo(){
        return customerService.getCurrentCustomer();
    }


    @RequestMapping(value = "/close_account", method = RequestMethod.DELETE)
    public Object closeExistingAccount(@Valid @RequestBody Account account){
        return customerService.deleteAccount(account);
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public Object deposit(@Valid @RequestBody Deposit deposit){
           return customerService.deposit(deposit);
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Object setupTransfer(@Valid @RequestBody Transfer transfer){
        return customerService.transferBetweenAccount(transfer);
    }



    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public Object setupPayment(@Valid @RequestBody Payment payment){
        return customerService.setupPayment(payment);
    }



    @RequestMapping(value = "/view_transaction", method = RequestMethod.GET)
    public List<Transaction> view_transactions(){
        return customerService.viewTransactions();
    }


    @RequestMapping(value = "/search_transactions", method = RequestMethod.GET)
    public Object search_transaction(@Valid @RequestBody SearchTransaction searchTransaction){
        return customerService.searchTransactions(searchTransaction);
    }

}
