package com.inexture.service;

import com.inexture.model.Customer;
import com.inexture.repo.CustomerRepo;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Iterable<Customer> saveAllCustomer(List<Customer> customers) {
        return customerRepo.saveAll(customers);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public Iterable<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> findByCity(String city) {
        return customerRepo.findByCity(city);
    }

    @Override
    public List<Customer> findByFirstName(String firstName,String lastName) {
        Query query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("firstName", firstName))
                .withQuery(QueryBuilders.matchQuery("lastName",lastName))
                .build();

//        Query query1 = new NativeSearchQueryBuilder().withQuery(QueryBuilders.boolQuery()
//                .must(QueryBuilders.matchQuery("firstName",firstName))).build();

        SearchHits<Customer> searchHits = elasticsearchRestTemplate.search(query, Customer.class);
        return  searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
