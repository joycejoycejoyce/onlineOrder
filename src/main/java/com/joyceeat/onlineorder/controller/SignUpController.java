package com.joyceeat.onlineorder.controller;

import com.joyceeat.onlineorder.entity.Customer;
import com.joyceeat.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {
    @Autowired
    private CustomerService customerService;


    // value = resource path
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
                         // 自动把 RequestBody -- convert Customer object
    public void signUp(@RequestBody Customer customer) {
        customerService.signUp(customer);
    }
}
