package home.sfg.beer.order.service.services;

import home.sfg.beer.order.service.domain.BeerOrder;

import java.util.UUID;

public interface BeerOrderManager {

  BeerOrder newBeerOrder(BeerOrder beerOrder);

  void processValidationResult(UUID beerOrderId, Boolean isValid);
}
