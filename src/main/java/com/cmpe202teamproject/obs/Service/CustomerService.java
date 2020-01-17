package com.cmpe202teamproject.obs.Service;

import com.cmpe202teamproject.obs.DataAccessObject.*;
import com.cmpe202teamproject.obs.Model.*;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final ExternalPayeeRepository externalPayeeRepository;
    private final PaymentRepository paymentRepository;
    private final TransferRepository transferRepository;
    private final DepositRepository depositRepository;
    private final FeesRepository feesRepository;
    private final ChecksRepository checksRepository;
    private Customer currentCustomer;
    private Date date;


    public CustomerService(CustomerRepository customerRepository, AccountRepository accountRepository, ExternalPayeeRepository externalPayeeRepository, PaymentRepository paymentRepository, TransferRepository transferRepository, DepositRepository depositRepository, FeesRepository feesRepository, ChecksRepository checksRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.externalPayeeRepository = externalPayeeRepository;
        this.paymentRepository = paymentRepository;
        this.transferRepository = transferRepository;
        this.depositRepository = depositRepository;
        this.feesRepository = feesRepository;
        this.checksRepository = checksRepository;
        this.date = new Date(System.currentTimeMillis());
    }

    public Object createCustomer(Customer customer) {
        JSONObject errorMessage = new JSONObject();
        JSONObject inputInvalid = new JSONObject();
        inputInvalid.put("Input Validation:",  "Please enter your customer name and password");
        errorMessage.put("Error Message","This customer name has already been registered, please choose another name to create a new account");

        if(customer.getCustomerName() == null || customer.getPassword() == null){
            return inputInvalid;
        }

        if(customerRepository.findByName(customer.getCustomerName()) != null) {
            return errorMessage;
        }
         customerRepository.save(customer);
        return customerRepository.findByName(customer.getCustomerName());
    }


    public Object signInCustomer(Customer customer){
           JSONObject errorMessage = new JSONObject();
           errorMessage.put("Error Message","You account information is incorrect, Please verify it again");
           String name = customer.getCustomerName();
           String password = customer.getPassword();
           if (customerRepository.validateCustomer(name, password) != null){
               currentCustomer = customerRepository.findByName(name);
               return currentCustomer;
           }else{
               return errorMessage;
           }
    }

    public Object addAccount(Account account){
           JSONObject errorMessage = new JSONObject();
           errorMessage.put("Input Validation:","Your account type is invalided" );
           if(!account.getAccountType().equals("Checking") && !account.getAccountType().equals("Saving")){
               return errorMessage;
           }
           if (account.getAccountType().equals("Checking")) {
               account.setAccountType("Checking");
           }
           if (account.getAccountType().equals("Saving")) {
            account.setAccountType("Saving");
           }
               account.generateAccountNum();
               account.setCustomerId(currentCustomer.getCustomerId());
               account.setBalance(0.00);
               accountRepository.save(account);
               return accountRepository.findAccount(account.getAccountNum());
    }

    public Object deleteAccount(Account account) {
           JSONObject errorMessage = new JSONObject();
           JSONObject successMessage = new JSONObject();
           errorMessage.put("Error Message:","Your account type is invalided" );
           successMessage.put("Message:", "Successfully deleted account !");
           if(accountRepository.findAccount(account.getAccountNum()) != null) {
               accountRepository.deleteAccount(account.getAccountNum());
               return successMessage;
           }else{
               return errorMessage;
           }
    }

    public Customer getCurrentCustomer() {
           return currentCustomer;
    }

    public Object deposit(Deposit deposit){
           JSONObject errorMessage = new JSONObject();
           errorMessage.put("Error Message:","This account is not exist");
           if( accountRepository.findAccount(deposit.getAccountNum()) == null){
               return errorMessage;
           }
           Account account = accountRepository.findAccount(deposit.getAccountNum());
           account.setBalance(account.getBalance() + deposit.getAmount());
           accountRepository.save(account);
           deposit.setDate(date);
           depositRepository.save(deposit);
           return accountRepository.findAccount(account.getAccountNum());
    }

    public Object transferBetweenAccount (Transfer transfer){
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("Error Message:","Your account information is incorrect" );
        JSONObject insufficientBalanceMessage = new JSONObject();
        insufficientBalanceMessage.put("Error Message:","Your sender account don't have enough balance to transfer");
        if (accountRepository.findAccount(transfer.getSenderAccountNum()) != null) {
            Account senderAccount = accountRepository.findAccount(transfer.getSenderAccountNum());
            Account receiverAccount = accountRepository.findAccount(transfer.getReceiverAccountNum());
            if (senderAccount.getBalance() > transfer.getAmount()) {
                senderAccount.setBalance(senderAccount.getBalance() - transfer.getAmount());
                receiverAccount.setBalance(receiverAccount.getBalance() + transfer.getAmount());
                accountRepository.save(senderAccount);
                accountRepository.save(receiverAccount);
                Date date = new Date(System.currentTimeMillis());
                transfer.setDate(date);
                transfer.setAccountId(senderAccount.getAccountId());
                transferRepository.save(transfer);
                return transferRepository.findFirstByOrderByTransferIdDesc();
            } else {
                return insufficientBalanceMessage;
            }
        } else {
            return errorMessage;
        }
    }


    public Object setupPayment(Payment payment){
        JSONObject senderAccountNotExist = new JSONObject();
        JSONObject externalPayeeNumberNotExist = new JSONObject();
        senderAccountNotExist.put("Error Message:", "The Sender account number is not exist");
        externalPayeeNumberNotExist.put("Error Message", "The external payee is not exist");
        if(accountRepository.findAccount(payment.getSenderAccountNum()) == null){
            return senderAccountNotExist;
        }
        if(externalPayeeRepository.findExternalPayee(payment.getExternalPayeeName()) == null){
            return externalPayeeNumberNotExist;
        }
        payment.setDate(date);
        Account senderAccount = accountRepository.findAccount(payment.getSenderAccountNum());
        ExternalPayee externalPayee = externalPayeeRepository.findExternalPayee(payment.getExternalPayeeName());
        senderAccount.setBalance(senderAccount.getBalance() - payment.getAmount());
        externalPayee.setBalance(externalPayee.getBalance() + payment.getAmount());
        accountRepository.save(senderAccount);
        externalPayeeRepository.save(externalPayee);
        payment.setAccountId(senderAccount.getAccountId());
        paymentRepository.save(payment);
        return paymentRepository.findFirstByOrderByPaymentIdDesc();
    }

    public List<Transaction> viewTransactions() {
        List<Transaction> allTransaction = new ArrayList<>();
        allTransaction.addAll(checksRepository.findAll());
        allTransaction.addAll(depositRepository.findAll());
        allTransaction.addAll(paymentRepository.findAll());
        allTransaction.addAll(transferRepository.findAll());
        allTransaction.addAll(feesRepository.findAll());
        return allTransaction;
    }

    public Object searchTransactions(SearchTransaction searchTransaction) {
        JSONObject typeErrorMSG = new JSONObject();
        JSONObject dateErrorMSG = new JSONObject();
        typeErrorMSG.put("Error Message:","Transaction type not found.");
        dateErrorMSG.put("Error Message:","Start date is too early, you can only search transactions up to last 18 months !");
        List<Transaction> debits = new ArrayList<>();
        debits.addAll(paymentRepository.findPaymentTransactions(searchTransaction.getStartDate(),date));
        debits.addAll(transferRepository.findTransferTransactions(searchTransaction.getStartDate(),date));
        if(searchTransaction.getStartDate().compareTo(Date.valueOf(LocalDate.now().minusMonths(18))) < 0){
            return dateErrorMSG;
        }

        switch (searchTransaction.getType()){
            case "Credits":
                return depositRepository.findDepositTransactions(searchTransaction.getStartDate(),date);
            case "Debits":
                return debits;
            case "Checks":
                return checksRepository.findCheckTransactions(searchTransaction.getStartDate(),date);
            case "Fees":
                return feesRepository.findFeesBetween(searchTransaction.getStartDate(),date);
            default:
                return typeErrorMSG;
        }
    }
}
