package home.sfg.beer.order.service.services;

import home.sfg.beer.order.service.domain.Customer;
import home.sfg.beer.order.service.repositories.CustomerRepository;
import home.sfg.beer.order.service.web.mappers.CustomerMapper;
import home.sfg.brewery.model.CustomerPageList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerPageList listCustomers(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        return new CustomerPageList(customerPage
                .stream()
                .map(customerMapper::customerToDto)
                .collect(Collectors.toList()),
                PageRequest.of(customerPage.getPageable().getPageNumber(),
                        customerPage.getPageable().getPageSize()),
                        customerPage.getTotalElements());
    }
}
