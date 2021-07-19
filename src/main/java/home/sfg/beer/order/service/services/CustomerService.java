package home.sfg.beer.order.service.services;

import home.sfg.brewery.model.CustomerPageList;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    CustomerPageList listCustomers(Pageable pageable);
}
