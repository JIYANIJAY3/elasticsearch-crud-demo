package com.inexture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {

    @Id
    private int id;
    private String country;
    private String city;
    private String pinCode;
    private String address;
}
