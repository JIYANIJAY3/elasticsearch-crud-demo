package com.inexture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "customer_details",createIndex = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Field(type = FieldType.Integer,name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long salary;

    @Field(type = FieldType.Nested)
    private CustomerAddress customerAddress;

}
