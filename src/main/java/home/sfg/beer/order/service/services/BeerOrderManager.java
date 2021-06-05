package home.sfg.beer.order.service.services;

import home.sfg.beer.order.service.domain.BeerOrder;
import home.sfg.brewery.model.BeerOrderDto;

import java.util.UUID;

public interface BeerOrderManager {

  BeerOrder newBeerOrder(BeerOrder beerOrder);

  void processValidationResult(UUID beerOrderId, boolean isValid);

  void beerOrderAllocationPassed(BeerOrderDto beerOrderDto);

  void beerOrderAllocationPendingInventory(BeerOrderDto beerOrderDto);

  void beerOrderAllocationFailed(BeerOrderDto beerOrderDto);
}
