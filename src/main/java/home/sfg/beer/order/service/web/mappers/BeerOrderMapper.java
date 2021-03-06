package home.sfg.beer.order.service.web.mappers;

import home.sfg.beer.order.service.domain.BeerOrder;
import home.sfg.brewery.model.BeerOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

  @Mapping(target = "customerId", source = "customer.id")
  BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

  BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
