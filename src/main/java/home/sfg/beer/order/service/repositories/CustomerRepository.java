package home.sfg.beer.order.service.repositories;

import home.sfg.beer.order.service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-01-26.
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
  List<Customer> findAllByCustomerNameLike(String customerName);
}
