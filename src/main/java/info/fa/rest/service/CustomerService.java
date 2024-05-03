package info.fa.rest.service;

import info.fa.model.dto.CustomerDto;
import info.fa.rest.enitity.Customer;
import info.fa.rest.repo.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    CustomerRepo customerRepo;

    public CustomerDto search(String customerRef) {
        Customer customer = customerRepo.findByCustomerRef(customerRef);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public void save(CustomerDto request) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        customerRepo.save(customer);
    }
}
