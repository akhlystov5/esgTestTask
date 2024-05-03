
CREATE TABLE customer (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `customer_ref` varchar(255) not NULL,
                          `customer_name` varchar(255) not NULL,
                          `address_line1` varchar(255) not NULL,
                          `address_line2` varchar(255) not NULL,
                          `town` varchar(255) not NULL,
                          `county` varchar(255) not NULL,
                          `country` varchar(255) not NULL,
                          `postcode` varchar(32) not NULL,
                          PRIMARY KEY (`id`),
                          CONSTRAINT customer_ref UNIQUE (customer_ref)
) ENGINE=InnoDB;
