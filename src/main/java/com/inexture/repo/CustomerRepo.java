package com.inexture.repo;

import com.inexture.model.Customer;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepo extends ElasticsearchRepository<Customer,Integer> {

    @Query("{\"nested\":{\"path\":\"customerAddress\",\"query\":{\"match\":{\"customerAddress.city\":\"?0\"}}}}")
    List<Customer> findByCity(String city);
}
