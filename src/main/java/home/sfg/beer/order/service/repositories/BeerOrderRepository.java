package home.sfg.beer.order.service.repositories;


import home.sfg.beer.order.service.domain.BeerOrder;
import home.sfg.beer.order.service.domain.BeerOrderStatusEnum;
import home.sfg.beer.order.service.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


/**
 * Created by jt on 2019-01-26.
 */
public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {

  Page<BeerOrder> findAllByCustomer(Customer customer, Pageable pageable);

  List<BeerOrder> findAllByOrderStatus(BeerOrderStatusEnum beerOrderStatusEnum);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
//  BeerOrder findOneById(UUID id);
}
