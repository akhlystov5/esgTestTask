package info.fa.rest.enitity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_ref")
    private String customerRef;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "town")
    private String town;

    @Column(name = "county")
    private String county;

    @Column(name = "country")
    private String country;

    @Column(name = "postcode")
    private String postcode;
}
