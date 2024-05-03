package info.fa.rest.controller;

import info.fa.model.dto.CustomerDto;
import info.fa.rest.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class CustomerController {

    CustomerService customerService;

    @GetMapping("/v1/customer/{customer_ref}")
    public CustomerDto search(@PathVariable(value = "customer_ref") String customerRef) {
        return customerService.search(customerRef);
    }

    @PostMapping ("/v1/customer")
    void save(@RequestBody CustomerDto request) {
        customerService.save(request);
    }
}
