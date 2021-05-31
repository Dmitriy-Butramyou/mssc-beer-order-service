package home.sfg.beer.order.service.services.beer;

import home.sfg.brewery.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {

  Optional<BeerDto> getBeerById(UUID uuid);

  Optional<BeerDto> getBeerByUpc(String upc);
}
