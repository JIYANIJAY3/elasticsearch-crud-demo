package com.inexture.repo;

import com.inexture.model.Customer;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepo extends ElasticsearchRepository<Customer,Integer> {

    @Query("{\"match\" : { \"city\" : \"?0\"}}")
    Customer findByCity(String city);
}
