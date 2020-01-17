package com.cmpe202teamproject.obs.Controller;

import com.cmpe202teamproject.obs.Model.Fees;
import com.cmpe202teamproject.obs.Service.AdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/fees", method = RequestMethod.POST)
    public Object addRefund(@RequestBody @Valid Fees fees){
        return adminService.addFees(fees);
    }
}
