package home.sfg.beer.order.service.web.mappers;

import home.sfg.beer.order.service.domain.Customer;
import home.sfg.brewery.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {

    CustomerDto customerToDto (Customer customer);

    Customer dtoToCustomer(CustomerDto dto);
}
