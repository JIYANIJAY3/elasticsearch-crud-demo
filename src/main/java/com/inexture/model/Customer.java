package com.inexture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "customer_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
