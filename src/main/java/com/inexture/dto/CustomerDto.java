package com.inexture.dto;

import com.inexture.model.CustomerAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long salary;
    private CustomerAddress customerAddress;

}
