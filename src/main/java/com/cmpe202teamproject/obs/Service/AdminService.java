package com.cmpe202teamproject.obs.Service;

import com.cmpe202teamproject.obs.DataAccessObject.AccountRepository;
import com.cmpe202teamproject.obs.DataAccessObject.FeesRepository;
import com.cmpe202teamproject.obs.Model.Account;
import com.cmpe202teamproject.obs.Model.Fees;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AdminService {
    private final AccountRepository accountRepository;
    private final FeesRepository feesRepository;
    private Date date;

    public AdminService(AccountRepository accountRepository, FeesRepository feesRepository) {
        this.accountRepository = accountRepository;
        this.feesRepository = feesRepository;
        this.date = new Date(System.currentTimeMillis());
    }

    // Admin add transactions to customer account
    public Object addFees(Fees fees){
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("Input Validation:","The account does not exist!" );
        if(accountRepository.findAccount(fees.getAccountNum()) != null) {
            Account account = accountRepository.findAccount(fees.getAccountNum());
            account.setBalance(account.getBalance()+ fees.getAmount());
            fees.setDate(date);
            accountRepository.save(account);
            fees.setAccountNum(account.getAccountNum());
            Date date = new Date(System.currentTimeMillis());
            fees.setDate(date);
            feesRepository.save(fees);
            return feesRepository.findFirstByOrderByFeesIdDesc();
        }else{
            return errorMessage;
        }

    }
}
