package home.sfg.beer.order.service.services;

import home.sfg.beer.order.service.domain.BeerOrder;

public interface BeerOrderManager {

  BeerOrder newBeerOrder(BeerOrder beerOrder);
}
