package home.sfg.beer.order.service.sm.actions;

import home.sfg.beer.order.service.config.JmsConfig;
import home.sfg.beer.order.service.domain.BeerOrder;
import home.sfg.beer.order.service.domain.BeerOrderEventEnum;
import home.sfg.beer.order.service.domain.BeerOrderStatusEnum;
import home.sfg.beer.order.service.repositories.BeerOrderRepository;
import home.sfg.beer.order.service.services.BeerOrderManagerImpl;
import home.sfg.beer.order.service.web.mappers.BeerOrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class AllocateOrderAction  implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

  private final JmsTemplate jmsTemplate;
  private final BeerOrderRepository beerOrderRepository;
  private final BeerOrderMapper beerOrderMapper;

  @Override
  public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> stateContext) {
    String beerOrderId = (String) stateContext.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
    BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOrderId));

    jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_QUEUE,
        beerOrderMapper.beerOrderToDto(beerOrder));

    log.debug("Sent allocation request for order id: " + beerOrderId);
  }
}