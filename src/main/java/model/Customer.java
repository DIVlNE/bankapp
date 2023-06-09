package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String phoneNumber;
}
