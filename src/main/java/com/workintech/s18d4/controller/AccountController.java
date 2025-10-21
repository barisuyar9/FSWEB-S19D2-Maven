package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;

    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Account> getAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return accountService.find(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@PathVariable int customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        account.setCustomer(customer);
        Account saved = accountService.save(account);

        return new AccountResponse(
                saved.getId(),
                saved.getAccountName(),
                saved.getMoneyAmount()
        );
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@PathVariable Long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        account.setCustomer(customer);
        Account updated = accountService.save(account);

        return new AccountResponse(
                updated.getId(),
                updated.getAccountName(),
                updated.getMoneyAmount()
        );
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable Long id) {
        // Ensure find is invoked before delete as expected by tests
        accountService.find(id);
        return accountService.delete(id);
    }
}
