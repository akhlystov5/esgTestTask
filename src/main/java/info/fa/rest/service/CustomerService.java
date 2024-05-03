package info.fa.rest.service;

import info.fa.util.Converter;
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

    Converter converter;

    public CustomerDto search(String customerRef) {
        Customer customer = customerRepo.findByCustomerRef(customerRef);
        CustomerDto customerDto = converter.convert(customer);
        return customerDto;
    }

    public void save(CustomerDto request) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        customerRepo.save(customer);
    }
}
