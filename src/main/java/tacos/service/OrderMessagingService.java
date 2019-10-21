package tacos.service;

import tacos.domain.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
