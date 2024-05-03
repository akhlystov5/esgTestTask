package info.fa.model.dto;

public record CustomerDtoRecord(String customerRef, String customerName,
                                String addressLine1, String addressLine2,
                                String town, String county,
                                String country, String postcode)
{ }
