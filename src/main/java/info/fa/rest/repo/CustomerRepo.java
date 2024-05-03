package info.fa.rest.repo;

import info.fa.rest.enitity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByCustomerRef(String customerRef);
}
